package com.service.godash.repository;

import com.service.godash.model.Buyer;
import com.service.godash.model.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SampleRequestRepo extends JpaRepository<Sample,Integer> {

    @Query("select b.srno from Sample b WHERE LOWER(b.srno) LIKE %:input%")
    List<String> findBysrno(@Param("input")String input);
}
