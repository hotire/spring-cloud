package com.github.hotire.circuitbreaker.resilience4j.core.rate_limiter;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import org.junit.jupiter.api.Test;

class RateLimiterCoreTest {

    @Test
    void acquirePermission() {
        // given
        final RateLimiter rateLimiter = RateLimiter.of("test", RateLimiterConfig.ofDefaults());

        // when
        final boolean result = rateLimiter.acquirePermission();

        // then
        assertThat(result).isTrue();
    }
}