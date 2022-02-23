package com.examples.graphql.resolver;


import com.examples.graphql.exception.NotFoundException;
import com.examples.graphql.model.Article;
import com.examples.graphql.model.ArticleInput;
import com.examples.graphql.service.ArticleService;
import com.examples.graphql.util.CommonUtils;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.security.SecureRandom;
import java.util.Optional;

@Component
@Slf4j
public class ArticleMutationResolver implements GraphQLMutationResolver {

    @Autowired
    ArticleService articleService;

    public Boolean deleteArticle(Long articleId) throws NotFoundException{
        Optional<Article> articleOptional = articleService.getArticleByID(articleId);
        if (articleOptional.isPresent()) {
            log.info("Deleting article with id {}", articleId);
            articleService.deleteArticle(articleId);
            log.info("Deleted article with id {}", articleId);
            return true;
        }
        throw new NotFoundException("Article not found for id: " + articleId);
    }

    public Article saveArticle( @Valid ArticleInput articleInput) {
        Article article = new Article();
//        log.info(articleInput.getMetaData().toString());
        BeanUtils.copyProperties(articleInput, article);
        article.setId((long) new SecureRandom().nextInt(100000));
        article.getMetaData().setUrl(CommonUtils.urlGenerator(article.getTitle(), article.getId()));

        log.info("start saving the article");
        return articleService.saveArticle(article);
    }

}
