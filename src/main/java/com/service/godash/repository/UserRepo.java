package com.service.godash.repository;
import com.service.godash.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract class UserRepo implements JpaRepository<User, String> {


}
