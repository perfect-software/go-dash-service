package com.service.godash.repository;

import com.service.godash.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ArticleRepo extends JpaRepository<Article, Integer> {
    @Query("SELECT a.articleId FROM Article a ORDER BY a.articleId")
    List<Integer> findAllArticleNo();

    @Query("SELECT a.articleName FROM Article a ORDER BY a.articleName")
    List<String> findAllArticleName();
    @Query("SELECT a FROM Article a WHERE a.articleId=:articleid")
    Article findByArticleId(int articleid);
    @Query("SELECT a.articleName FROM Article a where a.articleId=:articleid")
    String findArticleName(int articleid);


}
