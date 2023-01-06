package com.it.netty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NettyTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(NettyTestApplication.class, args);
    }
}
