package com.github.hotire.webservice.feign.fallback;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.hotire.webservice.feign.JSONPlaceHolderClientConfig;
import com.github.hotire.webservice.feign.JSONPlaceHolderClientFallback;
import com.github.hotire.webservice.feign.Post;

@FeignClient(value = "jplaceholder", url = "https://jsonplaceholder.typicode.com/", fallback = JSONPlaceHolderClientFallback.class, configuration = JSONPlaceHolderClientConfig.class)
public interface MyFeignClient {
    @GetMapping("/posts/{id}/123")
    List<Post> getPostsWithPathAndQuery(@PathVariable Long id, @RequestParam String name);

    @GetMapping("/posts")
    List<Post> getPosts();
}
