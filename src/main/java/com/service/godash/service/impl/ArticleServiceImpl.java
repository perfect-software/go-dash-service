package com.service.godash.service.impl;

import com.service.godash.Exception.DuplicationException;
import com.service.godash.model.Article;
import com.service.godash.model.ArticleMST;
import com.service.godash.model.Sample;
import com.service.godash.payload.ArticleRequest;
import com.service.godash.repository.ArticleMstRepo;
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

    @Autowired
    ArticleMstRepo articleMstRepo;
    @Override
    public String createArticle(ArticleRequest request) throws Exception {
        try {
            ArticleMST articleMST=new ArticleMST();
            articleMST.setArticle_no(request.getArticleNo());
            articleMST.setLast_no(request.getLastNo());
            articleMstRepo.save(articleMST);
            Article article=new Article(request);
            article.setArticlemst_id(articleMST.getArticleMstId());
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

    @Override
    public String updateArticle(ArticleRequest request) {
        Article existingRequest= articleRepo.findById(request.getArticleId()).orElse(null);
        if (existingRequest!= null) {
            Article article=convertArticleToDTO(existingRequest,request);
            articleRepo.save(article);
            return article.getArticleName();
        } else {
            throw new DuplicationException("Article does not exist");
        }
    }

    @Override
    public List<ArticleMST> getArticleMst() {
       return articleMstRepo.findAll();
    }

    private Article convertArticleToDTO(Article article, ArticleRequest request) {
        article.setArticleName(request.getArticleName());
        article.setAnimal(request.getAnimal());
        article.setColor(request.getColor());
        article.setComment(request.getComment());
        article.setCategory(request.getCategory());
        article.setGender(request.getGender());
        article.setImage_nm(request.getImage_nm());
        article.setHeelHeight(request.getHeelHeight());
        article.setHeelNo(request.getHeelNo());
        article.setHeelType(request.getHeelType());
        article.setLiningMaterial(request.getLiningMaterial());
        article.setUsername(request.getUsername());
        article.setPlatformNo(request.getPlatformNo());
        article.setPlatformType(request.getPlatformType());
        article.setToeShape(request.getToeShape());
        article.setLastNo(request.getLastNo());
        article.setSoleType(request.getSoleType());
        article.setSocksMaterial(request.getSocksMaterial());
        return article;
    }

}
