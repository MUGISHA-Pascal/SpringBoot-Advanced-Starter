package com.starter.backend.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import org.springdoc.webmvc.ui.SwaggerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerApiDoc {

    @Bean
    public OpenAPI customOpenAPI() {
        final String securitySchemeName = "bearerAuth";

        return new OpenAPI()
                .info(new Info()
                        .title("Spring Boot Advanced Starter")
                        .version("1.0.0")
                        .description("A spring boot starter kit for your project")
                        .termsOfService("https://github.com/MUGISHA-Pascal/SpringBoot-Advanced-Starter")
                        .contact(new Contact()
                                .name("MUGISHA Pascal")
                                .url("https://mugisha-pascal.vercel.app/")
                                .email("mugishapascal2008@gmail.com"))
                        .license(new io.swagger.v3.oas.models.info.License()
                                .name("MIT")
                                .url("https://github.com/MUGISHA-Pascal/SpringBoot-Advanced-Starter/blob/main/LICENSE")))
                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
                .components(new Components()
                        .addSecuritySchemes(securitySchemeName,
                                new SecurityScheme()
                                        .name(securitySchemeName)
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")));
    }
}
