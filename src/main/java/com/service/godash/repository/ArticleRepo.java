package com.service.godash.repository;

import com.service.godash.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArticleRepo extends JpaRepository<Article, Integer> {
    @Query("SELECT a.articleId FROM Article a ORDER BY article_id")
    List<Integer> findAllArticleNo();

    @Query("SELECT a.articleName FROM Article a ORDER BY article_id")
    List<String> findAllArticleName();

}
