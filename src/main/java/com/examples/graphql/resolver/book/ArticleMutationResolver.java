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
    //
    @Autowired
    ArticleService articleService;



    public Article saveBook(@Valid ArticleInput bookInput) {
        Article book = new Article();
//        log.info(articleInput.getMetaData().toString());
        BeanUtils.copyProperties(bookInput, book);
        book.setId((long) new SecureRandom().nextInt(100000));
        book.getMetaData().setUrl(CommonUtils.urlGenerator(book.getTitle(), book.getId()));
//        book.setDomainId(bookInput.getDomainId());
//        book.setTitle(bookInput.getTitle());
//        book.setMetaData(MetaData.builder()
//                        .metaTitle(bookInput.getMetaData().getMetaTitle())
//                        .authorEmail(bookInput.getMetaData().getAuthorEmail())
//                        .url(bookInput.getMetaData().getUrl())
//                        .canonicalUrl(bookInput.getMetaData().getCanonicalUrl())
//                .build());
//        book.setAuthor(Author.builder()
//                        .name(bookInput.getAuthor().getName())
//                        .city(bookInput.getAuthor().getCity())
//                .build());
//        book.setTemp(Temp.builder()
//                        .metaTitle(bookInput.getTemp().getMetaTitle())
//                        .metaDescription(bookInput.getTemp().getMetaDescription())
//                        .url(bookInput.getTemp().getUrl())
//                .build());

        log.info("start saving the article");
        return articleService.saveArticle(book);
    }

}
