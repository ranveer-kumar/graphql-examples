package com.examples.graphql.repository;

import com.examples.graphql.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;




public interface BookRepository extends MongoRepository<Book, Long> {

}
