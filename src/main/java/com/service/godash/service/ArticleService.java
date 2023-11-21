package com.service.godash.service;

import com.service.godash.model.Article;
import org.springframework.data.relational.core.sql.In;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ArticleService {

    ResponseEntity<?> createArticle(Article request);

    List<Integer> getArticleNo();

    List<String> getArticleName();

    List<Article> getArticle();

    List<Article> viewArticle(Integer page_num);
}
