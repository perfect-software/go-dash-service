package com.service.godash.repository;

import com.service.godash.model.SrBomDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SrBomDetailsRepo extends JpaRepository<SrBomDetails,Integer> {

    SrBomDetails findBybomId(Integer bomId);
}
