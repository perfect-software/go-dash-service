package com.service.godash.service;
import com.service.godash.dto.UserRegistrationRequest;
import com.service.godash.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public void registerUser(UserRegistrationRequest request){
        userRepo.save(request);
    }
}
