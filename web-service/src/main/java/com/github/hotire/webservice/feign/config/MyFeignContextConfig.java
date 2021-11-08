package com.github.hotire.webservice.feign.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.named.NamedContextFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyFeignContextConfig {

    @Autowired(required = false)
    private final List<NamedContextFactory.Specification> configurations = new ArrayList<>();

    @Bean
    public MyFeignContext myFeignContext() {
        final MyFeignContext context = new MyFeignContext();
        context.mySetConfigurations(configurations);
        return context;
    }

}
