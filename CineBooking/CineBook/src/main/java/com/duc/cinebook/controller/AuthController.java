package com.duc.cinebook.controller;

import com.duc.cinebook.dto.request.AuthServiceRequest;
import com.duc.cinebook.dto.request.LogoutRequest;
import com.duc.cinebook.dto.response.APIResponse;
import com.duc.cinebook.dto.response.AuthResponse;
import com.duc.cinebook.service.AuthenService;
import com.nimbusds.jose.JOSEException;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.text.ParseException;

@RequestMapping("/auth")
@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthController {
    private static final Logger log = LoggerFactory.getLogger(AuthController.class);
    @Autowired
    AuthenService authenService;


    @GetMapping("/login")
    APIResponse<AuthResponse> login(@RequestBody AuthServiceRequest request) throws JOSEException {
        var result = authenService.authenticate(request);
        return APIResponse.<AuthResponse>builder().data(result).build();

    }

    @PostMapping("/logout")
    APIResponse<Void> logout(@RequestHeader("Authorization") String token) throws JOSEException, ParseException {
        log.info("token : "+token);
        authenService.logout(token);

    return APIResponse.<Void>builder().build();
    }
}
