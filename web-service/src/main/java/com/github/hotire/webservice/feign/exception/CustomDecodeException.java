package com.github.hotire.webservice.feign.exception;

import feign.Request;
import feign.codec.DecodeException;

/**
 * @see feign.AsyncResponseHandler#decode
 */
public class CustomDecodeException extends DecodeException {
    public CustomDecodeException(int status, String message, Request request) {
        super(status, message, request);
    }
}
