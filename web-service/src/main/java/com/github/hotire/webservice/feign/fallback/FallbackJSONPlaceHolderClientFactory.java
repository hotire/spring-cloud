package com.github.hotire.webservice.feign.fallback;

import java.util.Collections;
import java.util.List;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.context.annotation.Configuration;

import com.github.hotire.webservice.feign.Post;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class FallbackJSONPlaceHolderClientFactory implements FallbackFactory<FallbackJSONPlaceHolderClient> {

    private final FallbackJSONPlaceHolderClient delegate = new FallbackJSONPlaceHolderClient() {

        @Override
        public List<Post> getPostsWithPathAndQuery(Long id, String name) {
//            throw new RuntimeException("error");
            if (1 == 1) {
                throw new RuntimeException("custom error");
            }
            return Collections.emptyList();
        }

        @Override
        public HttpResponse<List<Post>> getPosts() {
            return new HttpResponse(Collections.emptyList());
        }
    };

    @Override
    public FallbackJSONPlaceHolderClient create(Throwable cause) {
        log.error(cause.getMessage(), cause);
        return delegate;
    }
}
