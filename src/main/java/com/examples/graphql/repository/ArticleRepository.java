package com.examples.graphql.repository;

import com.examples.graphql.model.Article;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ArticleRepository extends MongoRepository<Article, Long> {

}
