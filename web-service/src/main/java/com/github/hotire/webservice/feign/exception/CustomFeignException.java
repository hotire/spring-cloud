package com.github.hotire.webservice.feign.exception;

import feign.FeignException;
import feign.Request;

/**
 * request is nullable
 * responseBody is nullable
 * contentUTF8() = responseBody.orEmpty()
 */
public class CustomFeignException extends FeignException {
    protected CustomFeignException(int status, String message, Throwable cause) {
        super(status, message, cause);
    }
    // boot 2.6.0 before
//    protected CustomFeignException(int status, String message, Request request, Throwable cause, byte[] responseBody) {
//        super(status, message, request, cause, responseBody);
//    }
}
