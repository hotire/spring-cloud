package com.github.hotire.webservice.feign.fallback;

import java.util.Collections;
import java.util.List;

import org.springframework.cloud.openfeign.FallbackFactory;

import com.github.hotire.webservice.feign.Post;

public class MyFeignClientFallbackFactory implements FallbackFactory<FallbackJSONPlaceHolderClient> {

    private final FallbackJSONPlaceHolderClient delegate = new FallbackJSONPlaceHolderClient() {

        @Override
        public List<Post> getPostsWithPathAndQuery(Long id, String name) {
            return Collections.emptyList();
        }

        @Override
        public List<Post> getPosts() {
            return Collections.emptyList();
        }
    };

    @Override
    public FallbackJSONPlaceHolderClient create(Throwable cause) {
        return delegate;
    }
}
