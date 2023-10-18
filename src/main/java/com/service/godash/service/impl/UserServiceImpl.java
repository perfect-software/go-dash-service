package com.service.godash.service.impl;

import com.service.godash.payload.MessageResponse;
import com.service.godash.payload.UserRegistrationRequest;
import com.service.godash.model.User;
import com.service.godash.repository.UserRepo;
import com.service.godash.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public ResponseEntity<?> registerUser(UserRegistrationRequest request) {
        if(userRepo.existsByemail(request.getEmail())){
            return ResponseEntity.badRequest().body(new MessageResponse("Email already in use"));
        }
        else{
            User user=new User();
            user.setFirstName(request.getFirstName());
            user.setLastName(request.getLastName());
            user.setEmail(request.getEmail());
            user.setPhone(request.getPhone());
            user.setPassword(request.getPassword());
            this.userRepo.save(user);

//            String token = UUID.randomUUID().toString();
//            ConfirmationToken confirmationToken = new ConfirmationToken(
//                    token,
//                    LocalDateTime.now(),
//                    LocalDateTime.now().plusMinutes(15),
//                    user
//            );

//            String link = "http://localhost:8080/api/auth/confirm?token="+token;
//            emailSender.send(signUpRequest.getEmail(), buildEmail(signUpRequest.getUsername(),link));
//            confirmationTokenService.saveConfirmationToken(confirmationToken);
//
            return ResponseEntity.ok(new MessageResponse("Your account has been registered.!Please confirm your email address."));
        }
    }
//
//    public boolean findUserByEmail(String email){
//            if(userRepo.findByEmail(email))
//            {
//                return true;
//            }
//            else return false;
//    }
}
