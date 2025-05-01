package com.starter.backend.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.*;

@Configuration
public class SwaggerApiDoc {
    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<>(Arrays.asList("application/json"));
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(appInfo()).consumes(DEFAULT_PRODUCES_AND_CONSUMES).produces(DEFAULT_PRODUCES_AND_CONSUMES).securityContexts(Arrays.asList(securityContext())).securitySchemes(Arrays.asList(apiKey())).select().apis(RequestHandlerSelectors.basePackage("com.starter.backend.controllers")).paths(PathSelectors.any()).build();
    }
    private SecurityContext securityContext(){
        return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }
    private List<SecurityReference> defaultAuth(){
        AuthorizationScope authorizationScope= new AuthorizationScope("global","accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0]=authorizationScope;
        return Arrays.asList(new SecurityReference("JWT",authorizationScopes));

    }
    private ApiKey apiKey(){
        return new ApiKey("JWT","authorization","header");
    }
    private ApiInfo appInfo(){
        return  new ApiInfo("Spring Boot advanced starter","a spring boot starter kit for your project","1.0.0","https://github.com/MUGISHA-Pascal/SpringBoot-Advanced-Starter",new Contact("MUGISHA Pascal","https://mugisha-pascal.vercel.app/","mugishapascal2008@gmail.com"),"MIT","https://github.com/MUGISHA-Pascal/SpringBoot-Advanced-Starter/blob/main/LISENCE", Collections.emptyList());
    }
}
