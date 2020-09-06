package com.article.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.article.entity.Article;
import com.article.service.ArticleService;

@RestController
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;
	
	@GetMapping("/article")
	public List<Article> getAllArticles()
	{
		return articleService.getAllArticles();
	}
	
	@GetMapping("/article/{id}")
	public Article getArticle(@PathVariable(value = "id") Long aid)
	{
		return articleService.getArticleById(aid);
	}
	
	@PostMapping("/article")
	public void createArticle(@Validated @RequestBody Article article)
	{
		 articleService.SaveOrUpdate(article);
	}
	
	@PutMapping("/article/{id}")
	public Article updateArticle(@PathVariable(value = "id")Article aid,@RequestBody Article article) {
		Article articles = articleService.SaveOrUpdate(aid);
		articles.setTitle(article.getTitle());
		articles.setCategory(article.getCategory());
		Article updateArticle = articleService.SaveOrUpdate(aid);		
		return updateArticle;
	}
	
	
	@DeleteMapping("/article/{id}")
	public void deleteArticle(@PathVariable(value = "id")Long aid)
	{
		articleService.deleteArticle(aid);
	}

}
