package com.service.godash.repository;

import com.service.godash.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ColorRepo extends JpaRepository<Color,Integer> {
    @Query("SELECT b.color FROM Color b WHERE LOWER(b.color) LIKE %:partialName%")
    List<String> findColorContainingIgnoreCase(@Param("partialName") String partialName);

}
