package com.examples.graphql.resolver;

import com.examples.graphql.domain.Author;
import com.examples.graphql.model.Image;
import com.examples.graphql.model.LeadMedia;
import com.examples.graphql.model.MediaType;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ImageFieldResolver implements GraphQLResolver<LeadMedia> {
    public List<Image> images(LeadMedia leadMedia){
        return Arrays.asList(Image.builder()
                .name("image anmae")
                .caption("image caption")
                .build());
    }
}
