package com.service.godash.repository;

import com.service.godash.model.BillOfMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BOMRepo extends JpaRepository<BillOfMaterial,Integer> {
}
