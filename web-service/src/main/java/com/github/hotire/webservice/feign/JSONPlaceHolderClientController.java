package com.github.hotire.webservice.feign;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequestMapping("/feign")
@RestController
@RequiredArgsConstructor
public class JSONPlaceHolderClientController {

    private final JSONPlaceHolderClient client;

    @GetMapping("/posts")
    public void getPosts() {
        client.getPosts();
    }
}
