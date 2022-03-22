package com.github.hotire.webservice.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "jplaceholder", url = "https://jsonplaceholder.typicode.com/", configuration = JSONPlaceHolderClientConfig.class)
public interface JSONPlaceHolderClient {

    @GetMapping("/posts/{id}/123")
    List<Post> getPostsWithPathAndQuery(@PathVariable Long id, @RequestParam String name);

    @GetMapping("/posts")
    List<Post> getPosts();
}