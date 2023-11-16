package com.service.godash.repository;

import com.service.godash.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepo extends JpaRepository<Article, Integer> {

}
