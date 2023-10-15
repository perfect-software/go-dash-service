package com.service.godash.controller;

import com.service.godash.dto.UserRegistrationRequest;
import com.service.godash.service.UserService;
import com.service.godash.validation.UserRegisterValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class EmpUserController {
    @Autowired
    UserRegisterValidation userRegisterValidation;
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public HttpStatus createUserSignUp(@RequestBody UserRegistrationRequest request) throws Exception {
        userRegisterValidation.validateRequest(request);
        userService.registerUser(request);
        return HttpStatus.OK;
    }
}
