package com.service.godash.repository;

import com.service.godash.model.ArticleMST;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleMstRepo extends JpaRepository<ArticleMST,Integer> {
}
