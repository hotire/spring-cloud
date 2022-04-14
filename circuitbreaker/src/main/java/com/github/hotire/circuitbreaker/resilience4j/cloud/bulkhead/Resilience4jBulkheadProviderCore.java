package com.github.hotire.circuitbreaker.resilience4j.cloud.bulkhead;

import java.util.function.Function;
import java.util.function.Supplier;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.timelimiter.TimeLimiter;
import io.vavr.collection.Map;

/**
 * @see org.springframework.cloud.circuitbreaker.resilience4j.Resilience4jBulkheadProvider
 */
public class Resilience4jBulkheadProviderCore {

    /**
     * @see org.springframework.cloud.circuitbreaker.resilience4j.Resilience4jBulkheadProvider#run(String, Supplier, Function, CircuitBreaker, TimeLimiter, Map)
     */
    public <T> T run(String id, Supplier<T> toRun, Function<Throwable, T> fallback, CircuitBreaker circuitBreaker,
                     TimeLimiter timeLimiter, io.vavr.collection.Map<String, String> tags) {
        return null;
    }

}
