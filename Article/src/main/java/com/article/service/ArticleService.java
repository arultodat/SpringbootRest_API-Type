package com.article.service;

import java.util.List;

import com.article.entity.Article;

public interface ArticleService {
	
	public List<Article> getAllArticles();
	
	public Article getArticleById(Long id);
	
	public Article SaveOrUpdate(Article article);
	
	public void deleteArticle(Long id);

}
