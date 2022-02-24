package com.examples.graphql.service;

import com.examples.graphql.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ArticleService {
	
	public Book saveArticle(Book article);
	public Optional<Book> getArticleByID(Long articleId);
	public Page<Book> getAllArticles(Pageable pageable);
	public void deleteArticle(Long articleId);
}
