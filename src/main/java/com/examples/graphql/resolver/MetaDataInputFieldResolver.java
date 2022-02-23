package com.examples.graphql.resolver;


import com.examples.graphql.model.Article;
import com.examples.graphql.model.ArticleInput;
import com.examples.graphql.model.MetaDataInput;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

@Component
public class MetaDataInputFieldResolver implements GraphQLResolver<Article> {
    public MetaDataInput metaDataInput(ArticleInput article){
        return MetaDataInput.builder()
                .authorEmail("abc@a.com")
                .build();
    }

}
