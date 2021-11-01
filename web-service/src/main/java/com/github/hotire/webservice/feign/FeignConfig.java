package com.github.hotire.webservice.feign;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * import
 * @see org.springframework.cloud.openfeign.FeignClientsRegistrar
 * a implemented ImportBeanDefinitionRegistrar
 */
@EnableFeignClients
@Configuration
public class FeignConfig {
}
