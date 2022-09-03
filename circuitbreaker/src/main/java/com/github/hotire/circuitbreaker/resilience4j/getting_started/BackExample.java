package com.github.hotire.circuitbreaker.resilience4j.getting_started;

import io.github.resilience4j.bulkhead.BulkheadFullException;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class BackExample {
  private static final String BACKEND = "backendA";

  @CircuitBreaker(name = BACKEND, fallbackMethod = "fallback")
  @RateLimiter(name = BACKEND)
  @Bulkhead(name = BACKEND, fallbackMethod = "fallback")
  @Retry(name = BACKEND)
  @TimeLimiter(name = BACKEND)
  public Mono<String> method(String param1) {
    return Mono.error(new NumberFormatException());
  }

  private Mono<String> fallback(String param1, CallNotPermittedException e) {
    return Mono.just("Handled the exception when the CircuitBreaker is open");
  }

  private Mono<String> fallback(String param1, BulkheadFullException e) {
    return Mono.just("Handled the exception when the Bulkhead is full");
  }

  private Mono<String> fallback(String param1, NumberFormatException e) {
    return Mono.just("Handled the NumberFormatException");
  }

  private Mono<String> fallback(String param1, Exception e) {
    return Mono.just("Handled any other exception");
  }
}
