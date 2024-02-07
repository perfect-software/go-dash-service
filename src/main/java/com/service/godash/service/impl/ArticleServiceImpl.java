package com.service.godash.service.impl;

import com.service.godash.model.Article;
import com.service.godash.model.Sample;
import com.service.godash.payload.ArticleRequest;
import com.service.godash.repository.ArticleRepo;
import com.service.godash.service.ArticleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleRepo articleRepo;
    @Override
    public String createArticle(ArticleRequest request) throws Exception {
        try {
            Article article=new Article(request);
            articleRepo.save(article);
            return article.getArticleName();
        }
        catch (Exception ex){
            throw new Exception(ex.getMessage());
        }

    }

    @Override
    public List<Integer> getArticleNo() {
        return articleRepo.findAllArticleNo();

    }

    @Override
    public List<String> getArticleName() {
       return articleRepo.findAllArticleName();
    }

    @Override
    public List<Article> getArticle() {
        List<Article> articleList = articleRepo.findAll();
        return articleList;
    }

    @Override
    public List<Article> viewArticle(Integer page_num) {
        Pageable pageable = PageRequest.of(page_num, 12);
        Page<Article> page = articleRepo.findAll(pageable);
        List<Article> resultList = page.getContent();
        return resultList;
    }

}
