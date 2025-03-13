package com.cloud.api.conf;

import feign.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class FeignLogConf {
    @Bean
    public Logger.Level feignLoggerLevel() {
        log.info("加载---- feignLoggerLevel");
        return Logger.Level.FULL;
    }
}
