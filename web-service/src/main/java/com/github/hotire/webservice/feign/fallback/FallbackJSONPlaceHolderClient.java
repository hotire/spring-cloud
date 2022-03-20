package com.github.hotire.webservice.feign.fallback;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.hotire.webservice.feign.Post;

@FeignClient(value = "fallbackClient", url = "https://jsonplaceholder.typicode.com/", fallbackFactory = FallbackJSONPlaceHolderClientFactory.class, configuration = FallbackConfig.class)
public interface FallbackJSONPlaceHolderClient {
    @GetMapping("/posts/{id}/123")
    List<Post> getPostsWithPathAndQuery(@PathVariable Long id, @RequestParam String name);

    @GetMapping("/posts")
    List<Post> getPosts();
}
