package com.github.hotire.webservice.feign;

import java.lang.reflect.Method;

import javax.annotation.PostConstruct;

import org.springframework.cloud.openfeign.CircuitBreakerNameResolver;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixEventType;
import com.netflix.hystrix.strategy.HystrixPlugins;
import com.netflix.hystrix.strategy.eventnotifier.HystrixEventNotifier;

import feign.Target;
import lombok.extern.slf4j.Slf4j;

/**
 * import
 * @see org.springframework.cloud.openfeign.FeignClientsRegistrar
 * a implemented ImportBeanDefinitionRegistrar
 */
@Slf4j
@EnableFeignClients
@Configuration
public class FeignConfig {

    @PostConstruct
    public void init() {
        HystrixPlugins.getInstance().registerEventNotifier(new HystrixEventNotifier() {
            @Override
            public void markEvent(HystrixEventType eventType, HystrixCommandKey key) {
                log.info("eventType : {}", eventType);
            }
        });
    }

    @Bean
    public CircuitBreakerNameResolver circuitBreakerNameResolver() {
        return (String feignClientName, Target<?> target, Method method) -> feignClientName + "_" + method.getName();
    }

}
