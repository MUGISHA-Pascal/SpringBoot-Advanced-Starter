package com.starter.backend.services;

import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class QueryResolver implements GraphQLQueryResolver {
    public String hello() {
        System.out.println("working");
        return "Hello, GraphQL!";
    }
}
