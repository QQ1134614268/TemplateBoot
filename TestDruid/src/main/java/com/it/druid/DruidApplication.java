package com.it.druid;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@SpringBootApplication
public class DruidApplication {
    public static void main(String[] args) {
        System.out.println("http://127.0.0.1:20624/druid");
        SpringApplication.run(DruidApplication.class, args);
    }
}
