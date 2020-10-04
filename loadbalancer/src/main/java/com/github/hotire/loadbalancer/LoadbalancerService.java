package com.github.hotire.loadbalancer;

import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class LoadbalancerService {
    private final WebClient webClient;

    public LoadbalancerService(final WebClient.Builder webClientBuilder, final ReactorLoadBalancerExchangeFilterFunction lbFunction) {
        this.webClient = webClientBuilder.filter(lbFunction).build();
    }

    public Mono<String> hello() {
        return webClient.get()
                        .uri("http://web-service/hello")
                        .retrieve()
                        .bodyToMono(String.class)
                        .log();
    }
}
