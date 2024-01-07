package com.service.godash.repository;

import com.service.godash.model.SrBom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BOMRepo extends JpaRepository<SrBom,Integer> {
}
