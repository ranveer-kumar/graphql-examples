package com.examples.graphql.service;

import com.examples.graphql.model.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ArticleService {
	
	public Article saveArticle(Article article);
	public Optional<Article> getArticleByID(Long articleId);
	public Page<Article> getAllArticles(Pageable pageable);
	public void deleteArticle(Long articleId);
}
