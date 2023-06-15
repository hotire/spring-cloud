package com.github.hotire.webservice.feign.encoder;

import feign.RequestTemplate;
import feign.codec.EncodeException;
import java.lang.reflect.Type;
import org.springframework.cloud.openfeign.support.PageableSpringEncoder;

/**
 * @see PageableSpringEncoder;
 */
public class PageableSpringEncoderCore {

    /**
     * @see PageableSpringEncoder#encode(Object, Type, RequestTemplate)
     */
    public void encode(Object object, Type bodyType, RequestTemplate template) throws EncodeException {

    }
}
