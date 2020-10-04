package com.github.hotire.loadbalancer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.context.TestConstructor.AutowireMode;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
@TestConstructor(autowireMode = AutowireMode.ALL)
@RequiredArgsConstructor
class LoadbalancerServiceTest {

    private final LoadbalancerService service;

    @Test
    void hello() {
        // when
        final Mono<String> result = service.hello();

        // then
        StepVerifier.create(result)
                    .expectNextCount(1)
                    .verifyComplete();
    }
}