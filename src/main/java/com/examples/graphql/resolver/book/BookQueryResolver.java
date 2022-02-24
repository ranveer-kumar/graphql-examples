package com.examples.graphql.resolver.book;


import com.examples.graphql.exception.NotFoundException;
import com.examples.graphql.model.Article;
import com.examples.graphql.model.Book;
import com.examples.graphql.repository.ArticleRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class BookQueryResolver implements GraphQLQueryResolver {

    @Autowired
    ArticleRepository bookRepository;

    public Article getBookById(Long bookId) throws NotFoundException {
        Optional<Article> articleOptional = bookRepository.findById(bookId);
        if (articleOptional.isPresent()) {
            return articleOptional.get();
        }
        throw new NotFoundException("Book not found for id: " + bookId);
    }



}
