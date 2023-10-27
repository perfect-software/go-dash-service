package com.service.godash.controller;

import com.service.godash.payload.UserLoginRequest;
import com.service.godash.payload.UserRegistrationRequest;
import com.service.godash.service.UserService;
import com.service.godash.validation.UserValidation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@OpenAPIDefinition(info = @Info(
        title = "Custom API title",
        version = "3.14"
))
public class EmpUserController {
    @Autowired
    UserValidation userValidation;
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> createUserSignUp(@Valid @RequestBody UserRegistrationRequest request) throws Exception {
            userValidation.validateRequest(request);
            return userService.registerUser(request);

    }

    @GetMapping("/login")
    public ResponseEntity<?> UserLogin(@Valid @RequestBody UserLoginRequest request) throws Exception {
        return userService.loginUser(request);

    }
}
