package com.examples.graphql.resolver.book;


import com.examples.graphql.model.MetaData;
import com.examples.graphql.model.Author;
import com.examples.graphql.model.Book;
import com.examples.graphql.model.BookInput;
import com.examples.graphql.model.Temp;
import com.examples.graphql.repository.BookRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

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
//        book.setMetaData(MetaData.builder()
//                        .metaTitle(bookInput.getMetaData().getMetaTitle())
//                        .authorEmail(bookInput.getMetaData().getAuthorEmail())
//                        .url(bookInput.getMetaData().getUrl())
//                        .canonicalUrl(bookInput.getMetaData().getCanonicalUrl())
//                .build());
        book.setAuthor(Author.builder()
                        .name(bookInput.getAuthor().getName())
                        .city(bookInput.getAuthor().getCity())
                .build());
        book.setTemp(Temp.builder()
                        .metaTitle(bookInput.getTemp().getMetaTitle())
                        .metaDescription(bookInput.getTemp().getMetaDescription())
                        .url(bookInput.getTemp().getUrl())
                .build());

        log.info("start saving the article");
        return bookRepository.save(book);
    }

}
