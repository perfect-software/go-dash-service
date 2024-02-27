package com.service.godash.controller;

import com.service.godash.Exception.GenericException;
import com.service.godash.model.Article;
import com.service.godash.model.ArticleMST;
import com.service.godash.model.Sample;
import com.service.godash.payload.ArticleRequest;
import com.service.godash.payload.ArticleUpdateRequest;
import com.service.godash.payload.MessageResponse;
import com.service.godash.payload.ServiceResponse;
import com.service.godash.service.ArticleService;
import com.service.godash.util.Utility;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/article")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @Autowired
    Utility utility;

    @PostMapping("/create")
    public ResponseEntity<ServiceResponse> createArticle(@Valid @RequestBody ArticleRequest request, BindingResult result) throws Exception {
        if (result.hasErrors()) {
            String errorMessage = result.getAllErrors().stream()
                    .map(error -> error.getDefaultMessage())
                    .collect(Collectors.joining(", "));
            ServiceResponse serviceResponse=ServiceResponse.builder()
                    .responseStatus(this.utility.getServiceResponse(errorMessage, HttpStatus.BAD_REQUEST.value())).build();
            return ResponseEntity.badRequest().body(serviceResponse);
        }
        try {
            String article_no=articleService.createArticle(request);
            ServiceResponse serviceResponse= ServiceResponse.builder()
                    .responseStatus(this.utility.getServiceResponse("Article Created", HttpStatus.CREATED.value())).response(article_no).build();
            return ResponseEntity.ok().body(serviceResponse);
        } catch (Exception ex) {
            ServiceResponse serviceResponse=ServiceResponse.builder()
                    .responseStatus(this.utility.getServiceResponse("Error while creating Article", HttpStatus.BAD_REQUEST.value())).build();
            return ResponseEntity.badRequest().body(serviceResponse);
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
            throw new Exception("Error while getting article");
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

    @PutMapping("/update")
    public ResponseEntity<ServiceResponse> updateArticle(@Valid @RequestBody ArticleUpdateRequest request, BindingResult result)throws Exception{
        if (result.hasErrors()) {
            String errorMessage = result.getAllErrors().stream()
                    .map(error -> error.getDefaultMessage())
                    .collect(Collectors.joining(", "));
            ServiceResponse serviceResponse=ServiceResponse.builder()
                    .responseStatus(this.utility.getServiceResponse(errorMessage, HttpStatus.BAD_REQUEST.value())).build();
            return ResponseEntity.badRequest().body(serviceResponse);
        }
        try {
            String article_no=articleService.updateArticle(request);
            ServiceResponse serviceResponse= ServiceResponse.builder()
                    .responseStatus(this.utility.getServiceResponse("Article Upated", HttpStatus.CREATED.value())).response(article_no).build();
            return ResponseEntity.ok().body(serviceResponse);
        } catch (Exception ex) {
            ServiceResponse serviceResponse=ServiceResponse.builder()
                    .responseStatus(this.utility.getServiceResponse("Error while updating Article", HttpStatus.BAD_REQUEST.value())).build();
            return ResponseEntity.badRequest().body(serviceResponse);
        }
    }

    @GetMapping("/getArticleMst")
    public List<ArticleMST> getArticleMst()
    {
        return articleService.getArticleMst();
    }


}
