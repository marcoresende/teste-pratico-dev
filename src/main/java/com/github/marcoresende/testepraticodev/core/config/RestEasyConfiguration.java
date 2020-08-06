package com.github.marcoresende.testepraticodev.core.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.springframework.context.annotation.Configuration;

import com.github.marcoresende.testepraticodev.web.rest.PopulacaoResource;

@Configuration
@ApplicationPath("/api")
public class RestEasyConfiguration extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(PopulacaoResource.class);
        return classes;
    }
}
