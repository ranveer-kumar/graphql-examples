package com.examples.graphql.resolver;

import com.examples.graphql.model.Article;
import com.examples.graphql.model.MetaData;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

@Deprecated
@Component
public class MetaDataFieldResolver implements GraphQLResolver<Article> {
//    public MetaData metaData(Article article){
//        return MetaData.builder()
//                .metaTitle("This is meta title")
//                .url("http://google.com")
//                .build();
//    }
}
