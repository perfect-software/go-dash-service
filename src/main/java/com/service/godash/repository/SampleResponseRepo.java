package com.service.godash.repository;

import com.service.godash.payload.SampleResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleResponseRepo extends JpaRepository<SampleResponse,Integer> {
}
