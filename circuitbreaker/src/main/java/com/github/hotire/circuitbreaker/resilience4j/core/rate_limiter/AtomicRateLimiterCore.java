package com.github.hotire.circuitbreaker.resilience4j.core.rate_limiter;

import static java.lang.System.nanoTime;
import static java.lang.Thread.currentThread;
import static java.util.concurrent.locks.LockSupport.parkNanos;

import io.github.resilience4j.ratelimiter.internal.AtomicRateLimiter;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.RequiredArgsConstructor;

/**
 * @see AtomicRateLimiter
 */
@RequiredArgsConstructor
public class AtomicRateLimiterCore {

    private final long nanoTimeStart;

    private final AtomicInteger waitingThreads;

    public long currentNanoTime() {
        return nanoTime() - nanoTimeStart;
    }

    /**
     * @see AtomicRateLimiter#waitForPermission(long)
     */
    public boolean waitForPermission(final long nanosToWait) {
        waitingThreads.incrementAndGet();
        long deadline = currentNanoTime() + nanosToWait;
        boolean wasInterrupted = false;
        while (currentNanoTime() < deadline && !wasInterrupted) {
            long sleepBlockDuration = deadline - currentNanoTime();
            parkNanos(sleepBlockDuration);
            wasInterrupted = Thread.interrupted();
        }
        waitingThreads.decrementAndGet();
        if (wasInterrupted) {
            currentThread().interrupt();
        }
        return !wasInterrupted;
    }

}
