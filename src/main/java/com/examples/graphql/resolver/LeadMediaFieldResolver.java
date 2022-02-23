package com.examples.graphql.resolver;

import com.examples.graphql.model.Article;
import com.examples.graphql.model.LeadMedia;

import com.examples.graphql.model.MediaType;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

@Component
public class LeadMediaFieldResolver implements GraphQLResolver<Article> {
    public LeadMedia leadMedia(Article article){
        return LeadMedia.builder()
                .mediaType(MediaType.ARTICLE)
                .build();
    }
}
