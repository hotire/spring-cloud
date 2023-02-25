package com.github.hotire.circuitbreaker.resilience4j.core.rate_limiter;

import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.internal.AtomicRateLimiter;

/**
 * @see RateLimiter
 * @see AtomicRateLimiter
 */
public class RateLimiterCore {

    /**
     * @see RateLimiter#acquirePermission(int) 
     */
    boolean acquirePermission(int permits) {
        return false;
    }
}
