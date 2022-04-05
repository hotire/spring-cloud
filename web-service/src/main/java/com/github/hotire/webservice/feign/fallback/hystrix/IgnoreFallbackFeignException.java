package com.github.hotire.webservice.feign.fallback;

import feign.FeignException;

/**
 * HystrixBadRequestException
 */
public class IgnoreFallbackFeignException extends RuntimeException {

    private final FeignException feignException;

    public IgnoreFallbackFeignException(FeignException feignException) {
        super(feignException.getMessage());
        this.feignException = feignException;
    }
}
