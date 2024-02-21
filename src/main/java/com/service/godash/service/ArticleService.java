package com.service.godash.service;

import com.service.godash.model.Article;
import com.service.godash.model.ArticleMST;
import com.service.godash.payload.ArticleRequest;
import org.springframework.data.relational.core.sql.In;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ArticleService {

    String createArticle(ArticleRequest request) throws Exception;

    List<Integer> getArticleNo();

    List<String> getArticleName();

    List<Article> getArticle();

    List<Article> viewArticle(Integer page_num);

    String updateArticle(ArticleRequest request);

    List<ArticleMST> getArticleMst();
}
