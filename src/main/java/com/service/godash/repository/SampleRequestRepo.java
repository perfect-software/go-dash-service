package com.service.godash.repository;

import com.service.godash.model.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleRequestRepo extends JpaRepository<Sample,Integer> {
}
