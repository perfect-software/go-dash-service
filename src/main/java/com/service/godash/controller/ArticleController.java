package com.service.godash.controller;

import com.service.godash.model.Article;
import com.service.godash.service.ArticleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/article")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @PostMapping("/create")
    public ResponseEntity<?> createArticle(@Valid @RequestBody Article request) throws Exception {
        return articleService.createArticle(request);

    }

    @GetMapping("/getArticleNo")
    public ResponseEntity<?> getArticleNo() throws Exception {
        return articleService.getArticleNo();

    }

    @GetMapping("/getArticleName")
    public ResponseEntity<?> getArticleName() throws Exception {
        return articleService.getArticleName();

    }
}
