package com.service.godash.controller;

import com.service.godash.model.Article;
import com.service.godash.model.Sample;
import com.service.godash.service.ArticleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<Integer> getArticleNo() throws Exception {
        return articleService.getArticleNo();

    }

    @GetMapping("/getArticleName")
    public List<String> getArticleName() throws Exception {
        return articleService.getArticleName();

    }
    @GetMapping("/getArticle")
    public List<Article> getArticle() throws Exception {
        return articleService.getArticle();

    }

    @GetMapping("/view")
    public List<Article> viewArticle(@Valid @RequestParam int page_num) throws Exception {
        return articleService.viewArticle(page_num);
    }
}
