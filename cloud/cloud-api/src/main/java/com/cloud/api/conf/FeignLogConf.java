package com.cloud.api.conf;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignLogConf {
    @Bean
    Logger.Level feignLoggerLevel() {
        System.out.println("'==================='");
        return Logger.Level.FULL;
    }
}
