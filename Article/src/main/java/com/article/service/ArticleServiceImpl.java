package com.article.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.article.entity.Article;
import com.article.repository.ArticleRepository;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleRepository articleRepository;
	
	@Override
	public List<Article> getAllArticles() {
		
		return articleRepository.findAll();
	}

	@Override
	public Article getArticleById(Long id) {
		
		return articleRepository.findById(id).get();
	}

	@Override
	public Article SaveOrUpdate(Article article) {
		
		return articleRepository.save(article);
	}

	@Override
	public void deleteArticle(Long id) {
		
		articleRepository.deleteById(id);
	}

}
