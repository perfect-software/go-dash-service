package com.service.godash.repository;

import com.service.godash.model.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BuyerRepo extends JpaRepository<Buyer, Integer> {
    @Query("SELECT b.bsName FROM Buyer b WHERE LOWER(b.bsName) LIKE %:partialName%")
    List<String> findBsNameContainingIgnoreCase(@Param("partialName") String partialName);

//    @Query("SELECT b.* FROM Buyer b WHERE LOWER(b.bsName) LIKE %:partialName%")
    List<Buyer> findByBsNameContainingIgnoreCase(@Param("partialName") String partialName);
}