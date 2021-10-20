package com.github.hotire.webservice.feign.decoder;

import java.io.IOException;
import java.lang.reflect.Type;

import org.springframework.cloud.openfeign.support.SpringDecoder;

import feign.FeignException;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SpringDecoderDecorator implements Decoder {
    private final SpringDecoder decoder;

    @Override
    public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
        return decoder.decode(response, type);
    }
}
