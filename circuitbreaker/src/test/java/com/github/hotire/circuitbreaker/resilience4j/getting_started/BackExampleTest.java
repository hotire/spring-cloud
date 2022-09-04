package com.github.hotire.circuitbreaker.resilience4j.getting_started;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;

@Slf4j
@SpringBootTest
class BackExampleTest {

  @Autowired
  private BackExample backExample;

  @Test
  void method() {
    final Mono<String> mono = backExample.method("hello");
    mono
        .doOnError(e -> log.error(e.getMessage(), e))
        .subscribe(log::info);
  }

}