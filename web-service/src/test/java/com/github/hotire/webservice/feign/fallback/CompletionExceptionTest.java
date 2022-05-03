package com.github.hotire.webservice.feign.fallback;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class CompletionExceptionTest {

    @Test
    void joinWithError() {
        try {
            CompletableFuture<Object> resultFuture = new CompletableFuture<>();
            resultFuture.completeExceptionally(new RuntimeException("completeExceptionally error"));
            resultFuture.join();
        } catch (CompletionException e) {
            log.warn(e.getMessage(), e);
        }

        try {
            CompletableFuture<Object> resultFuture = new CompletableFuture<>();
            resultFuture.completeAsync(() -> { throw new RuntimeException("throw error"); } );
            resultFuture.join();
        } catch (CompletionException e) {
            log.warn(e.getMessage(), e);
        }

    }
}
