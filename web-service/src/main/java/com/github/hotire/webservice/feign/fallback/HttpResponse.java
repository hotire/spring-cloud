package com.github.hotire.webservice.feign.fallback;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
public class HttpResponse<T> {
    private T data;

    @JsonCreator
    public HttpResponse(T data) {
        this.data = data;
    }
}
