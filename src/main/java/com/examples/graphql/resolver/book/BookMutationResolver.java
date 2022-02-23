package com.examples.graphql.resolver.book;


import com.examples.graphql.exception.NotFoundException;
import com.examples.graphql.model.Article;
import com.examples.graphql.model.ArticleInput;
import com.examples.graphql.model.MetaData;
import com.examples.graphql.model.book.Author;
import com.examples.graphql.model.book.Book;
import com.examples.graphql.model.book.BookInput;
import com.examples.graphql.repository.BookRepository;
import com.examples.graphql.service.ArticleService;
import com.examples.graphql.util.CommonUtils;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.security.SecureRandom;
import java.util.Optional;

@Component
@Slf4j
public class BookMutationResolver implements GraphQLMutationResolver {
//
//    @Autowired
//    ArticleService articleService;

    @Autowired
    BookRepository bookRepository;


    public Book saveBook(@Valid BookInput bookInput) {
        Book book = new Book();
//        log.info(articleInput.getMetaData().toString());
        BeanUtils.copyProperties(bookInput, book);
        book.setId(bookInput.getId());
        book.setDomainId(bookInput.getDomainId());
        book.setTitle(bookInput.getTitle());
        book.setMetaData(MetaData.builder()
                        .metaTitle(bookInput.getMetaData().getMetaTitle())
                        .authorEmail(bookInput.getMetaData().getAuthorEmail())
                .build());
        book.setAuthor(Author.builder()
                        .name(bookInput.getAuthor().getName())
                        .city(bookInput.getAuthor().getCity())
                .build()
        );

        log.info("start saving the article");
        return bookRepository.save(book);
    }

}
