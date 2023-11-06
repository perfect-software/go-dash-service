package com.service.godash.repository;

import com.service.godash.model.BsAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BsAccountRepo extends JpaRepository<BsAccount,Integer> {
}
