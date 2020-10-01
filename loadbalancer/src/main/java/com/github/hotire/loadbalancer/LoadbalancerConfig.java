package com.github.hotire.loadbalancer;

import java.util.List;

import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.hotire.loadbalancer.LoadbalancerConfig.WebServiceConfig;

import reactor.core.publisher.Flux;

@Configuration
@LoadBalancerClient(name = "web-service", configuration = WebServiceConfig.class)
public class LoadbalancerConfig {

    public static class WebServiceConfig {
        @Bean
        public ServiceInstanceListSupplier serviceInstanceListSupplier() {
            return new AbstractServiceInstanceListSupplier("web-service") {
                @Override
                public Flux<List<ServiceInstance>> get() {
                    return Flux.just(List.of(new DefaultServiceInstance(getServiceId() + "1", getServiceId(), "localhost", 8081, false)));
                }
            };
        }
    }
}
