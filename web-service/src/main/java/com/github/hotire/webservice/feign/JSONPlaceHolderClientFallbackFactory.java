package com.github.hotire.webservice.feign;

import org.springframework.cloud.openfeign.FallbackFactory;

public class JSONPlaceHolderClientFallbackFactory implements FallbackFactory<JSONPlaceHolderClient> {

    @Override
    public JSONPlaceHolderClient create(Throwable cause) {
        return null;
    }
}
