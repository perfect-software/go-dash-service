package com.service.godash.repository;

import com.service.godash.model.SampleRef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SampleRefRepo extends JpaRepository<SampleRef,Integer> {
    @Query("select b.srno from SampleRef b WHERE LOWER(b.srno) LIKE %:input% and b.buyer.bs_id=:bsId")
    List<String> findBysrno(@Param("input")String input, @Param("bsId")int bsId);

    @Query("select b.srno from SampleRef b WHERE  b.buyer.bs_id=:bsId")
    List<String> findBybuyersrno(@Param("bsId")int bsId);
}
