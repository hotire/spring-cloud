package com.github.hotire.circuitbreaker.resilience4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.hotire.circuitbreaker.resilience4j.aspect.Resilience4jAspectService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class Resilience4jController {

    private final Resilience4jAspectService resilience4jAspectService;

    @GetMapping("/hello")
    public String hello() {
        return resilience4jAspectService.hello();
    }
}
