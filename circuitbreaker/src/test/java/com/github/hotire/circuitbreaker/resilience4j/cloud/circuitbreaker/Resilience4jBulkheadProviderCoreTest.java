package com.github.hotire.circuitbreaker.resilience4j.cloud.circuitbreaker;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.function.Supplier;

import org.junit.jupiter.api.Test;

class Resilience4jBulkheadProviderCoreTest {

    /**
     * circuitBreakerCall
     * timeLimiterCall
     * bulkheadCall
     * toRun
     */
    @Test
    void run() throws Exception {
        Supplier<String> toRun = () -> {
            System.out.println("toRun");
            return "hello";
        };

        Supplier<CompletionStage<String>> bulkheadCall = () -> {
            System.out.println("bulkheadCall");
            return CompletableFuture.supplyAsync(toRun);
        };

        final Callable<String> timeLimiterCall = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("timeLimiterCall");
                return bulkheadCall.get().toCompletableFuture().get();
            }
        };
        final Callable<String> circuitBreakerCall = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("circuitBreakerCall");
                return timeLimiterCall.call();
            }
        };

        circuitBreakerCall.call();
    }
}