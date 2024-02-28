package com.service.godash.repository;

import com.service.godash.model.ArticleMST;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleMstRepo extends JpaRepository<ArticleMST,Integer> {
    ArticleMST findByArticleNo(String articleNo);

    ArticleMST findByLastNo(String articleNo);

    @Query("SELECT a FROM ArticleMST a WHERE a.articleNo=:articleNo AND a.lastNo=:lastNo")
    ArticleMST findByArticleNoAndLastNo(String articleNo, String lastNo);
    @Query("SELECT a.articleMstId FROM ArticleMST a WHERE a.articleNo=:articleNo AND a.lastNo=:lastNo")
    Integer findArticleMsBytArticleNoAndLastNo(String articleNo, String lastNo);
}
