package com.github.hotire.webservice.feign;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JSONPlaceHolderClientTest {

    @Autowired
    private JSONPlaceHolderClient client;

    @Test
    void getPosts() {
        client.getPosts();
    }
}