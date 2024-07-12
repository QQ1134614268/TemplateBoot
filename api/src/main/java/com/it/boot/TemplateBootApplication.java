package com.it.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching// 开启基于注解的缓存
@SpringBootApplication
public class TemplateBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(TemplateBootApplication.class, args);
    }

}
