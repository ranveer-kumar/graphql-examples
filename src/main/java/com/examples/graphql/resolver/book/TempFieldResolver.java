//package com.examples.graphql.resolver.book;
//
//import com.examples.graphql.model.Book;
//import com.examples.graphql.model.Temp;
//import graphql.kickstart.tools.GraphQLResolver;
//import org.springframework.stereotype.Component;
//
//@Component
//public class TempFieldResolver implements GraphQLResolver<Book> {
//    public Temp temp(Book book){
//        return Temp.builder()
//                .url(book.getTemp().getUrl())
//                .metaDescription(book.getTemp().getMetaDescription())
//                .metaTitle(book.getTemp().getMetaTitle())
//                .build();
//    }
//}
