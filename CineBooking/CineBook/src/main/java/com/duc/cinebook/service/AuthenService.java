package com.duc.cinebook.service;

import com.duc.cinebook.dto.request.AuthServiceRequest;
import com.duc.cinebook.dto.request.LogoutRequest;
import com.duc.cinebook.dto.response.AuthResponse;
import com.duc.cinebook.dto.response.LogoutResponse;
import com.duc.cinebook.entity.RedisToken;
import com.duc.cinebook.entity.Role;
import com.duc.cinebook.entity.Users;
import com.duc.cinebook.exception.APIException;
import com.duc.cinebook.exception.ErrorTime;
import com.duc.cinebook.repository.RedisTokenRepository;
import com.duc.cinebook.repository.UserRepository;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AuthenService {
    private static final Logger log = LoggerFactory.getLogger(AuthenService.class);
    @Value("${jwt.signerKey}")
    String signerKey;

    @Value("${jwt.valid-duration}")
    String validDuration;

    @Value("${jwt.refresh-duration}")
    String refreshDuration;
    @Autowired
    UserRepository userRepository;

    @Autowired
    RedisTokenRepository redisTokenRepository;


    public AuthResponse authenticate(AuthServiceRequest request) throws JOSEException {
        Users user =
                userRepository
                        .findByEmail(request.getEmail());


        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        boolean matches = passwordEncoder.matches(request.getPassword(), user.getPassword());

        if (!matches) {
            throw new APIException(ErrorTime.ERROR_LOGIN_FAILED);
        }
        var token = generateToken(user);

        return AuthResponse.builder().token(token).valid(true).build();
    }
    public AuthResponse introspect(AuthResponse request)
            throws ParseException, JOSEException {
        var token = request.getToken();
        try {
            verify(token, false);
        } catch (APIException e) {
            return AuthResponse.builder().valid(false).build();
        }
        return AuthResponse.builder().valid(true).build();
    }

    private SignedJWT verify(String token, boolean refresh) throws ParseException, JOSEException {
        JWSVerifier verifier = new MACVerifier(signerKey.getBytes());
        SignedJWT signedJWT = SignedJWT.parse(token);
        Date expiryDate =
                (refresh)
                        ? new Date(
                        signedJWT
                                .getJWTClaimsSet()
                                .getExpirationTime()
                                .toInstant()
                                .plus(Long.parseLong(refreshDuration), ChronoUnit.SECONDS)
                                .toEpochMilli())
                        : signedJWT.getJWTClaimsSet().getExpirationTime();
        var verified = signedJWT.verify(verifier);
        if (!(verified && expiryDate.after(new Date()))) {
            throw new APIException(ErrorTime.ERROR_AUTHOR);
        }
        if (redisTokenRepository.existsById(signedJWT.getJWTClaimsSet().getJWTID())) {
            log.info("Token has expired!");
            throw new APIException(ErrorTime.ERROR_AUTHOR);
        }
        return signedJWT;
    }

    private String generateToken(Users user) throws JOSEException {
        JWSSigner signer = new MACSigner(signerKey.getBytes());
        List<Role> roles = user.getRoles();
        List<String> roleNames = roles.stream().map(Role::getName).collect(Collectors.toList());
        JWSHeader algorithmHeader = new JWSHeader(JWSAlgorithm.HS256);

        JWTClaimsSet jwtClaimsSet =
                new JWTClaimsSet.Builder()
                        .subject(user.getEmail())
                        .issueTime(new Date())
                        .expirationTime(
                                new Date(
                                        Instant.now()
                                                .plus(Long.parseLong(validDuration), ChronoUnit.SECONDS)
                                                .toEpochMilli()))
                        .jwtID(UUID.randomUUID().toString())
                        .claim("roles", roleNames)
                        .build();

        SignedJWT signedJWT = new SignedJWT(algorithmHeader, jwtClaimsSet);
        signedJWT.sign(signer);
        return signedJWT.serialize();
    }

    public void logout(String token) throws ParseException, JOSEException {
        try {
            var signedJWT = verify(token, true);

            String jit = signedJWT.getJWTClaimsSet().getJWTID();
            Date expirationDate = signedJWT.getJWTClaimsSet().getExpirationTime();
            long timeToLive = (expirationDate.getTime() - new Date().getTime()) / 1000;
            log.info("Logged out of " + timeToLive + " seconds");

            RedisToken redisToken = RedisToken.builder().jwtId(jit).timeToLive(timeToLive).build();

            redisTokenRepository.save(redisToken);
            log.info("Saved token to Redis with ID: {} and TTL: {} seconds", redisToken.getJwtId(), redisToken.getTimeToLive());

        } catch (APIException exception) {
            log.info("Token not valid");
        }
    }
}
