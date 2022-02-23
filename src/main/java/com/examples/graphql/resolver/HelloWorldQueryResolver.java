package com.examples.graphql.resolver;

import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldQueryResolver implements GraphQLQueryResolver {
    public String helloWorld(){
        return "Hellow world form graphql";
    }
}
