package com.github.hotire.webservice.feign.fallback;

import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.netflix.hystrix.HystrixCircuitBreakerFactory;
import org.springframework.context.annotation.Bean;

//@Configuration
public class FallbackConfig {

    @Bean
    public Customizer<HystrixCircuitBreakerFactory> customizer() {
        return new Customizer<HystrixCircuitBreakerFactory>() {
            @Override
            public void customize(HystrixCircuitBreakerFactory factory) {
//                factory.configure();
            }
        };
    }


}