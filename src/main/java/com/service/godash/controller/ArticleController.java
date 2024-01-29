package com.service.godash.controller;

import com.service.godash.Exception.GenericException;
import com.service.godash.model.Article;
import com.service.godash.model.Sample;
import com.service.godash.payload.ArticleRequest;
import com.service.godash.payload.MessageResponse;
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
    public ResponseEntity<?> createArticle(@Valid @RequestBody ArticleRequest request) throws Exception {
        try {
            articleService.createArticle(request);
            return ResponseEntity.ok(new MessageResponse("Article Created"));
        } catch (Exception ex) {
            throw new GenericException("Error while creating article", 500);
        }
    }

    @GetMapping("/getArticleNo")
    public List<Integer> getArticleNo() throws Exception {
        try{
        return articleService.getArticleNo();
        } catch (Exception ex) {
            throw new GenericException("Error while getting article no", 500);
        }
    }

    @GetMapping("/getArticleName")
    public List<String> getArticleName() throws Exception {
        try {
            return articleService.getArticleName();
        } catch (Exception ex) {
            throw new GenericException("Error while getting article name", 500);
        }
    }
    @GetMapping("/getArticle")
    public List<Article> getArticle() throws Exception {
        try {
            return articleService.getArticle();
        } catch (Exception ex) {
            throw new GenericException("Error while getting article", 500);
        }
    }

    @GetMapping("/view")
    public List<Article> viewArticle(@Valid @RequestParam int page_num) throws Exception {
        try{
        return articleService.viewArticle(page_num);
        } catch (Exception ex) {
            throw new GenericException("Error while viewing article", 500);
        }
    }
}
