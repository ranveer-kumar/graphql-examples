package com.examples.graphql.resolver;

import com.examples.graphql.model.Image;
import com.examples.graphql.model.LeadMedia;
import com.examples.graphql.model.Video;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class VideoFieldResolver implements GraphQLResolver<LeadMedia> {
    public List<Video> videos(LeadMedia leadMedia) {
        return Arrays.asList(Video.builder()
                .embedUrl("embed")
                .caption("image caption")
                .build());
    }
}
