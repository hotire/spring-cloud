package com.github.hotire.webservice.feign.exception;

import feign.Request;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RequestAdapter {
    private final Request request;
}
