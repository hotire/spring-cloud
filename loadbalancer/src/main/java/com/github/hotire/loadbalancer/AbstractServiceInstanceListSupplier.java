package com.github.hotire.loadbalancer;

import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractServiceInstanceListSupplier implements ServiceInstanceListSupplier {

    private final String serviceId;

    @Override
    public String getServiceId() {
        return serviceId;
    }
}
