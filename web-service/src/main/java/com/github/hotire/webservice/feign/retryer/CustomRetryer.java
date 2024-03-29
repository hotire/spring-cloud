package com.github.hotire.webservice.feign.retryer;

import feign.RetryableException;
import feign.Retryer;
import lombok.RequiredArgsConstructor;

/**
 * @see Retryer.Default
 */
@RequiredArgsConstructor
public class CustomRetryer implements Retryer {

    private final int maxAttempts;
    private final long period;
    private final long maxPeriod;
    int attempt;
    long sleptForMillis;

    @Override
    public void continueOrPropagate(RetryableException e) {

    }

    @Override
    public Retryer clone() {
        return new CustomRetryer(maxAttempts, period, maxPeriod);
    }
}
