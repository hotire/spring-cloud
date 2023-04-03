package com.github.hotire.webservice.feign.retryer;

import feign.RetryableException;
import feign.Retryer;
import io.github.resilience4j.core.IntervalFunction;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JitterBasedRetryer implements Retryer  {
    private final int maxAttempts;
    private final long period;
    private final long maxPeriod;
    private final double multiplier;
    private final double randomizationFactor;
    int attempt;
    long sleptForMillis;

    @Override
    public void continueOrPropagate(RetryableException e) {
        if (attempt++ >= maxAttempts) {
            throw e;
        }

        long interval;
        if (e.retryAfter() != null) {
            interval = e.retryAfter().getTime() - currentTimeMillis();
            if (interval > maxPeriod) {
                interval = maxPeriod;
            }
            if (interval < 0) {
                return;
            }
        } else {
            interval = nextMaxInterval();
        }
        try {
            Thread.sleep(interval);
        } catch (InterruptedException ignored) {
            Thread.currentThread().interrupt();
            throw e;
        }
        sleptForMillis += interval;
    }

    protected long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    protected long nextMaxInterval() {
        return IntervalFunction.ofExponentialRandomBackoff(period, multiplier, randomizationFactor, maxPeriod)
            .apply(attempt);
    }

    @Override
    public Retryer clone() {
        return new JitterBasedRetryer(maxAttempts, period, maxPeriod, multiplier, randomizationFactor);
    }
}
