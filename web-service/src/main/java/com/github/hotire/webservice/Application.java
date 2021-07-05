package com.github.hotire.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(BookProperties.class)
@SpringBootApplication
public class Application {
    public static void main(String ... args) {
        SpringApplication.run(Application.class);
    }
}
