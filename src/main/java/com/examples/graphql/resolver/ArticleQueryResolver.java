package com.examples.graphql.resolver;


import com.examples.graphql.exception.NotFoundException;
import com.examples.graphql.model.Article;
import com.examples.graphql.service.ArticleService;
import graphql.kickstart.tools.GraphQLQueryResolver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class ArticleQueryResolver implements GraphQLQueryResolver {

    @Autowired
    ArticleService articleService;

    public Article getArticleById(Long articleId) throws NotFoundException {
        Optional<Article> articleOptional = articleService.getArticleByID(articleId);
        if (articleOptional.isPresent()) {
            return articleOptional.get();
        }
        throw new NotFoundException("Article not found for id: " + articleId);
    }


    public Page<Article> getAllArticles(Integer page, Integer size,
                                        String sortBy,
                                        String sortDirection) {
        log.info("Before getAllArticles with page {}  and size {}", page, size);
        PageRequest pageRequest = PageRequest.of(page != null ? page : 0, size != null ? size : 10, Sort.by(Sort.Direction.fromString(sortDirection), sortBy));
        return articleService.getAllArticles(pageRequest);
    }

    public void deleteArticle(Long articleId) {
        log.info("Deleting article with id {}", articleId);
        articleService.deleteArticle(articleId);
        log.info("Deleted article with id {}", articleId);
    }
}
