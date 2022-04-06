package com.github.hotire.webservice.feign.fallback;

import static feign.FeignException.errorStatus;

import org.springframework.context.annotation.Bean;

import feign.FeignException;
import feign.FeignException.FeignClientException;
import feign.Response;
import feign.RetryableException;
import feign.Retryer;
import feign.codec.ErrorDecoder;

//@Configuration
public class FallbackConfig {

    /**
     * @see FeignClientException
     */
    @Bean
    public ErrorDecoder errorDecoder() {
        return new ErrorDecoder() {
            @Override
            public Exception decode(String methodKey, Response response) {
                FeignException exception = errorStatus(methodKey, response);
                int status = response.status();
//                if (status >= 500) {
//                    return new IgnoreFallbackFeignException(exception);
//                }
                if (status >= 400) {
                    return new RetryableException(
                            response.status(),
                            exception.getMessage(),
                            response.request().httpMethod(),
                            exception,
                            null,
                            response.request());
                }
                return exception;
            }
        };
    }

    @Bean
    public Retryer retryer() {
        return new Retryer.Default(100, 100, 3);
    }

}