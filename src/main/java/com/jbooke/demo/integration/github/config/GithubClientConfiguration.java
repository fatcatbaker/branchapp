package com.jbooke.demo.integration.github.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;


public class GithubClientConfiguration {
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public GithubErrorDecoder errorDecoder() {
        return new GithubErrorDecoder();
    }
}

