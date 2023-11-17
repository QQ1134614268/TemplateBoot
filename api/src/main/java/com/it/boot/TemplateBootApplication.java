package com.it.boot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@Slf4j
@EnableScheduling
@SpringBootApplication
@EnableCaching//开启基于注解的缓存
public class TemplateBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(TemplateBootApplication.class, args);
    }

}
