package com.github.hotire.webservice.feign.config;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.cloud.context.named.NamedContextFactory;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;

/**
 * @see org.springframework.cloud.context.named.NamedContextFactory
 * @see org.springframework.cloud.openfeign.FeignContext
 * @see FeignAutoConfiguration#feignContext()
 */
public class MyFeignContext<C extends NamedContextFactory.Specification> extends NamedContextFactory<C> {

    private final Map<String, C> myConfigurations = new ConcurrentHashMap<>();

    public MyFeignContext() {
        super(FeignClientsConfiguration.class, "feign", "feign.client.name");
    }

    public void mySetConfigurations(List<C> configurations) {
        for (C client : configurations) {
            this.myConfigurations.put(client.getName(), client);
        }
    }

}
