package com.github.hotire.webservice.feign.retryer;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JitterBasedRetryer {
    private final int maxAttempts;
    private final long period;
    private final long maxPeriod;
    int attempt;
    long sleptForMillis;

}
