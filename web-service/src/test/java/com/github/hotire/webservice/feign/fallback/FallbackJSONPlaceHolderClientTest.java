package com.github.hotire.webservice.feign.fallback;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class FallbackJSONPlaceHolderClientTest {

    @Autowired
    private FallbackJSONPlaceHolderClient client;

    @Test
    void getPostsWithPathAndQuery() throws InterruptedException {
        try {
            client.getPostsWithPathAndQuery(1L, "");
        } catch (Exception e) {
        }
        try {
            client.getPostsWithPathAndQuery(1L, "");
        } catch (Exception e) {
        }

        Thread.sleep(3000L);
    }

    @Test
    void getPosts() {
        var result = client.getPosts();
        log.info("{}", result);
    }
}