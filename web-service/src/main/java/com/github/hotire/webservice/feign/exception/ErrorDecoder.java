package com.github.hotire.webservice.feign.exception;

import feign.Response;

public class ErrorDecoder implements feign.codec.ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        return null;
    }
}
