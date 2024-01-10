package com.service.godash.repository;

import com.service.godash.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BsAccountRepo extends JpaRepository<BankAccount,Integer> {
}
