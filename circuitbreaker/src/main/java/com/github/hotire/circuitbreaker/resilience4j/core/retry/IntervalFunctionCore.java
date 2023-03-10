package com.github.hotire.circuitbreaker.resilience4j.core.retry;

import io.github.resilience4j.core.IntervalFunction;

/**
 * @see IntervalFunction
 */
public class IntervalFunctionCore {

    /**
     * @see IntervalFunction#DEFAULT_INITIAL_INTERVAL
     */
    long DEFAULT_INITIAL_INTERVAL = 500;
    /**
     * @see IntervalFunction#DEFAULT_MULTIPLIER
     */
    double DEFAULT_MULTIPLIER = 1.5;
    /**
     * @see IntervalFunction#DEFAULT_RANDOMIZATION_FACTOR
     */
    double DEFAULT_RANDOMIZATION_FACTOR = 0.5;


    /**
     * @see IntervalFunction#ofExponentialBackoff(long, double, long)
     */
    static IntervalFunction ofExponentialRandomBackoff(
        long initialIntervalMillis,
        double multiplier,
        double randomizationFactor
    ) {
        return IntervalFunction.ofExponentialRandomBackoff(initialIntervalMillis,multiplier,randomizationFactor);
    }
}
