package com.github.hotire.webservice.feign.config;

import feign.codec.Decoder;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.cloud.openfeign.support.HttpMessageConverterCustomizer;

/**
 * @see FeignClientsConfiguration
 */
public class FeignClientsConfigurationCore {


    /**
     * @see FeignClientsConfiguration#feignDecoder(ObjectProvider) 
     */
    public Decoder feignDecoder(ObjectProvider<HttpMessageConverterCustomizer> customizers) {
        return null;
    }
}
