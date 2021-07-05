package com.github.hotire.webservice;

import javax.annotation.PostConstruct;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@ConfigurationProperties(prefix = "book")
public class BookProperties {
    private String name;

    @PostConstruct
    public void init() {
        log.info("name : {}", getName());
    }
}
