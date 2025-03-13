package com.cloud.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class TestBean {
    @Bean
    public Long getLong() {
        log.error("test ----------bean");
        return 0L;
    }
}
