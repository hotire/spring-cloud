package com.github.hotire.webservice.feign.config;

import org.springframework.cloud.context.named.NamedContextFactory;

/**
 * @see org.springframework.cloud.openfeign.FeignClientSpecification
 */
public class MyFeignClientSpecification implements NamedContextFactory.Specification {
    @Override
    public String getName() {
        return null;
    }

    @Override
    public Class<?>[] getConfiguration() {
        return new Class[0];
    }
}
