package com.service.godash.service;

import com.service.godash.model.Article;
import org.springframework.http.ResponseEntity;

public interface ArticleService {

    ResponseEntity<?> createArticle(Article request);

    ResponseEntity<?> getArticleNo();

    ResponseEntity<?> getArticleName();
}
