package com.examples.graphql.resolver.book;


import com.examples.graphql.model.Article;
import com.examples.graphql.model.ArticleInput;
import com.examples.graphql.service.ArticleService;
import com.examples.graphql.util.CommonUtils;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.security.SecureRandom;

@Component
@Slf4j
public class ArticleMutationResolver implements GraphQLMutationResolver {
    @Autowired
    ArticleService articleService;

    public Article saveArticle(@Valid ArticleInput articleInput) {
        Article article = new Article();
        BeanUtils.copyProperties(articleInput, article);
        article.setId((long) new SecureRandom().nextInt(100000));
        article.getMetaData().setUrl(CommonUtils.urlGenerator(article.getTitle(), article.getId()));
        log.info("start saving the article");
        return articleService.saveArticle(article);
    }
}
