package com.github.hotire.circuitbreaker.resilience4j.core.retry;

/**
 * @see io.github.resilience4j.core.IntervalFunctionCompanion
 */
public class IntervalFunctionCompanionCore {

    /**
     * @see io.github.resilience4j.core.IntervalFunctionCompanion#randomize(double, double) 
     */
    static double randomize(final double current, final double randomizationFactor) {
        final double delta = randomizationFactor * current;
        final double min = current - delta;
        final double max = current + delta;

        return (min + (Math.random() * (max - min + 1)));
    }
}
