package com.github.hotire.webservice.feign.exception;

import feign.codec.EncodeException;

public class CustomEncodeException extends EncodeException {
    public CustomEncodeException(String message) {
        super(message);
    }

    public CustomEncodeException(String message, Throwable cause) {
        super(message, cause);
    }
}
