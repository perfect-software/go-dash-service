package com.service.godash.repository;

import com.service.godash.model.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SampleRequestRepo extends JpaRepository<Sample,Integer> {

    @Query("SELECT COUNT(s.srno) FROM Sample s WHERE SUBSTRING(s.srno, CHARINDEX('/', s.srno) + 1, LEN(s.srno) - CHARINDEX('/', REVERSE(s.srno))) =:finYear")
    Integer findCountSRNO(String finYear);

    @Query("SELECT s FROM Sample s ORDER BY s.sampleId DESC")
    List<Sample> findAllByOrderBySampleIdDesc();

    Sample findBySrno(String sr_no);
}
