package com.examples.graphql.repository;

import com.examples.graphql.model.Article;
import com.examples.graphql.model.book.Book;
import org.springframework.data.mongodb.repository.MongoRepository;




public interface BookRepository extends MongoRepository<Book, Long> {

}
