package com.github.hotire.webservice.feign.fallback;

import com.netflix.hystrix.exception.HystrixBadRequestException;

import feign.FeignException;

public class IgnoreFallbackFeignException extends HystrixBadRequestException {

    private final FeignException feignException;

    public IgnoreFallbackFeignException(FeignException feignException) {
        super(feignException.getMessage());
        this.feignException = feignException;
    }
}
