package com.github.hotire.webservice.feign;

import org.springframework.context.annotation.Bean;

public class JSONPlaceHolderClientConfig {

    @Bean
    public JSONPlaceHolderClientFallback jsonPlaceHolderClientFallback() {
        return new JSONPlaceHolderClientFallback();
    }
}
