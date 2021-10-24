package com.github.hotire.webservice.feign.decoder;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;

import feign.Response;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomFeignResponseAdapter implements ClientHttpResponse {
    @Getter
    private final Response delegate;

    @Override
    public HttpStatus getStatusCode() throws IOException {
        return null;
    }

    @Override
    public int getRawStatusCode() throws IOException {
        return 0;
    }

    @Override
    public String getStatusText() throws IOException {
        return null;
    }

    @Override
    public void close() {

    }

    @Override
    public InputStream getBody() throws IOException {
        return null;
    }

    @Override
    public HttpHeaders getHeaders() {
        return null;
    }
}
