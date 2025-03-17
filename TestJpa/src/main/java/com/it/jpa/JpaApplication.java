package com.it.jpa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class JpaApplication {
    public static void main(String[] args) {
        System.out.println("http://127.0.0.1:8080/druid");
        SpringApplication.run(JpaApplication.class, args);
    }
}
