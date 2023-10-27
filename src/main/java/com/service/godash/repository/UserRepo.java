package com.service.godash.repository;


import com.service.godash.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    Boolean existsByemail(String email);

    Boolean existsByusername(String username);

    Boolean existsByphone(String phone);

    User findByUsername(String username);

}
