package com.starter.backend.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {

    @Bean
    public Hibernate5Module datatypeHibernateModule() {
        Hibernate5Module module = new Hibernate5Module();
        module.disable(Hibernate5Module.Feature.USE_TRANSIENT_ANNOTATION);
        return module;
    }
}
