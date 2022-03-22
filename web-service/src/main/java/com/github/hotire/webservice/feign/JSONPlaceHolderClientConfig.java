package com.github.hotire.webservice.feign;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import feign.Feign;
import feign.Retryer;

public class JSONPlaceHolderClientConfig {

    @Bean
    public JSONPlaceHolderClientFallback jsonPlaceHolderClientFallback() {
        return new JSONPlaceHolderClientFallback();
    }

    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder(Retryer retryer) {
        return Feign.builder().retryer(retryer);
    }
}
