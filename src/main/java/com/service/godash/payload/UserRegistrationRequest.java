package com.service.godash.payload;
import lombok.Data;
import lombok.NonNull;

@Data
public class UserRegistrationRequest {
//    @NonNull
//    private String firstName;
//    @NonNull
//    private String lastName;
    @NonNull
    private String username;
    @NonNull
    private String email;
    @NonNull
    private String phone;
    @NonNull
    private String password;
}
