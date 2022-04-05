package com.github.hotire.webservice.feign;

import java.lang.reflect.Method;

import org.springframework.cloud.openfeign.CircuitBreakerNameResolver;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Target;
import lombok.extern.slf4j.Slf4j;

/**
 * import
 * a implemented ImportBeanDefinitionRegistrar
 */
@Slf4j
@EnableFeignClients
@Configuration
public class FeignConfig {

    @Bean
    public CircuitBreakerNameResolver circuitBreakerNameResolver() {
        return (String feignClientName, Target<?> target, Method method) -> feignClientName + "_" + method.getName();
    }

}
