package com.service.godash.service.impl;

import com.service.godash.model.Article;
import com.service.godash.repository.ArticleRepo;
import com.service.godash.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleRepo articleRepo;
    @Override
    public ResponseEntity<?> createArticle(Article request) {
        articleRepo.save(request);
        return ResponseEntity.ok("Article Created");
    }
}
