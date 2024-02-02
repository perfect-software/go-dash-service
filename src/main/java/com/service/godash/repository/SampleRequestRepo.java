package com.service.godash.repository;

import com.service.godash.model.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SampleRequestRepo extends JpaRepository<Sample,Integer> {

    @Query("SELECT COUNT(s.sr_no) FROM Sample s WHERE SUBSTRING(s.sr_no, CHARINDEX('/', s.sr_no) + 1, LEN(s.sr_no) - CHARINDEX('/', REVERSE(s.sr_no))) =:finYear")
    Integer findCountSRNO(String finYear);

    @Query("SELECT s FROM Sample s ORDER BY s.sampleId DESC")
    List<Sample> findAllByOrderBySampleIdDesc();
}
