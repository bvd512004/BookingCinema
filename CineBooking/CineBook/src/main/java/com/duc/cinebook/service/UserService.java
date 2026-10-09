package com.duc.cinebook.service;

import com.duc.cinebook.dto.request.UserCreationRequest;
import com.duc.cinebook.dto.response.UserResponse;
import com.duc.cinebook.entity.Role;
import com.duc.cinebook.entity.Users;
import com.duc.cinebook.exception.APIException;
import com.duc.cinebook.exception.ErrorTime;
import com.duc.cinebook.mapper.UserMapper;
import com.duc.cinebook.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserService {

     final UserRepository userRepository;
     final UserMapper userMapper;


    public UserResponse createUser(UserCreationRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new APIException(ErrorTime.ERROR_CREATE_EMAIL_FAILED);
        }

        Users user = userMapper.UserCreationRequesttoUsers(request);

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        List<Role> roles = new ArrayList<>();
        Role role = new Role();
        role.setName("USER");
        roles.add(role);
        user.setRoles(roles);
       userRepository.save(user);

        return userMapper.toUserResponse(user);
    }
}
