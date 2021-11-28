package com.github.hotire.webservice.feign.fallback;

import org.springframework.cloud.openfeign.FallbackFactory;

public class MyFeignClientFallbackFactory implements FallbackFactory<MyFeignClient> {

    private final MyFeignClient delegate = new MyFeignClient() {
        @Override
        public void post() {

        }
    };

    @Override
    public MyFeignClient create(Throwable cause) {
        return delegate;
    }
}
