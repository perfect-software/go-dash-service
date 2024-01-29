package com.service.godash.repository;

import com.service.godash.model.FinYear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FinYearRepo extends JpaRepository<FinYear,Integer> {
    @Query("SELECT MAX(s.year) FROM FinYear s")
    Integer findyear();
}
