package com.service.godash.repository;

import com.service.godash.model.SampleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SampleTypeRepo extends JpaRepository<SampleType, Integer> {
    @Query("SELECT LTRIM(RTRIM(type)) FROM SampleType")
    List<String> findAllType();
}
