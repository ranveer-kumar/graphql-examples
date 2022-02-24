package com.examples.graphql.service;

import com.examples.graphql.model.Article;
import com.examples.graphql.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	ArticleRepository articleRepository;

	@Override
	public Article saveArticle(Article article) {
		return articleRepository.save(article);
	}

	@Override
	public Optional<Article> getArticleByID(Long articleId) {
		log.debug("Before getArticleByID with articleId {}", articleId);
		return articleRepository.findById(articleId);
	}

	@Override
	public Page<Article> getAllArticles(Pageable pageable) {
		log.debug("Before getAllArticles with pageable parameter");
		return articleRepository.findAll(pageable);
	}
	
	@Override
	public void deleteArticle(Long articleId) {
		articleRepository.deleteById(articleId);
		
	}
}
