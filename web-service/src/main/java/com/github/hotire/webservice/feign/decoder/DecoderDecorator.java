package com.github.hotire.webservice.feign.decoder;

import java.io.IOException;
import java.lang.reflect.Type;

import feign.FeignException;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import lombok.RequiredArgsConstructor;

/**
 * @see org.springframework.cloud.openfeign.support.SpringDecoder
 */
@RequiredArgsConstructor
public class DecoderDecorator implements Decoder {

    private final Decoder decoder;

    @Override
    public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
        return decoder.decode(response, type);
    }
}
