package com.article.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.article.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Long>{

}
