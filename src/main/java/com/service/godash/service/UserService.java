package com.service.godash.service;

import com.service.godash.payload.UserRegistrationRequest;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<?> registerUser(UserRegistrationRequest user);

//    boolean findUserByEmail(String email);
}
