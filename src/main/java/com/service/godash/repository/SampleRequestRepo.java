package com.service.godash.repository;

import com.service.godash.model.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleRequestRepo extends JpaRepository<Sample,Integer> {

    @Query("SELECT COUNT(s.sr_no) FROM Sample s WHERE s.finYear=:finYear")
    Integer findCountSRNO(String finYear);
}
