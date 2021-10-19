package com.github.hotire.webservice.feign.decoder;

import java.lang.reflect.Type;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.HttpMessageConverterExtractor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomHttpMessageConverterExtractor<T> extends HttpMessageConverterExtractor<T> {
    public CustomHttpMessageConverterExtractor(Class responseType, List list) {
        super(responseType, list);
    }

    public CustomHttpMessageConverterExtractor(Type responseType, List list) {
        super(responseType, list);
    }

    @Override
    protected MediaType getContentType(ClientHttpResponse response) {
        MediaType contentType = response.getHeaders().getContentType();
        if (contentType == null) {
            if (log.isTraceEnabled()) log.trace("No content-type, using 'application/json'");
            contentType = MediaType.APPLICATION_JSON;
        }
        return contentType;
    }
}
