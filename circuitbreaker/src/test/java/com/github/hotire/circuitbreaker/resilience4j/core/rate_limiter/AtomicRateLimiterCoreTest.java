package com.github.hotire.circuitbreaker.resilience4j.core.rate_limiter;

import static java.util.concurrent.locks.LockSupport.parkNanos;

import java.time.Duration;
import org.junit.jupiter.api.Test;

class AtomicRateLimiterCoreTest {

    @Test
    void testParkNanos() {
        parkNanos(Duration.ofSeconds(1).toNanos());
    }
}