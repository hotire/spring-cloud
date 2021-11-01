package com.github.hotire.webservice.feign.config;

import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.cloud.openfeign.FeignContext;

/**
 * @see org.springframework.cloud.context.named.NamedContextFactory
 * @see FeignAutoConfiguration#feignContext()
 */
public class MyFeignContext extends FeignContext {
}
