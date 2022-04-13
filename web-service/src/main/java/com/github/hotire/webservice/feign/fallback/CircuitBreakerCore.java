package com.github.hotire.webservice.feign.fallback;

import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.cloud.client.circuitbreaker.NoFallbackAvailableException;

/**
 * @see org.springframework.cloud.client.circuitbreaker.CircuitBreaker
 * @see org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreaker
 */
public interface CircuitBreakerCore {

    default <T> T run(Supplier<T> toRun) {
        return run(toRun, throwable -> {
            throw new NoFallbackAvailableException("No fallback available.", throwable);
        });
    };

    <T> T run(Supplier<T> toRun, Function<Throwable, T> fallback);
}
