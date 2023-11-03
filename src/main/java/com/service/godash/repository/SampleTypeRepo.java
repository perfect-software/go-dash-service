package com.service.godash.repository;

import com.service.godash.model.SampleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SampleTypeRepo extends JpaRepository<SampleType, Integer> {

    List<SampleType> findAll();
}
