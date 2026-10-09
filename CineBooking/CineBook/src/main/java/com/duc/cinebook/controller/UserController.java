package com.duc.cinebook.controller;

import com.duc.cinebook.dto.request.UserCreationRequest;
import com.duc.cinebook.dto.response.UserResponse;
import com.duc.cinebook.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.Access;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor

public class UserController {

   @Autowired UserService userService;

    @PostMapping
    public UserResponse createUser(@RequestBody UserCreationRequest request) {
        log.info("Creating user: {}", request);
        return userService.createUser(request);
    }
}
