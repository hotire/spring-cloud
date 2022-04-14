package com.github.hotire.circuitbreaker.resilience4j.aspect;

import org.springframework.stereotype.Service;

@Service
public class Resilience4jAspectService {

    public String hello() {
        return "hello";
    }
}
