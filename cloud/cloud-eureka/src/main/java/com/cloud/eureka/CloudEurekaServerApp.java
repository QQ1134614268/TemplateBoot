package com.cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer// 开启注册中心server
@SpringBootApplication
public class CloudEurekaServerApp {
	public static void main(String[] args) {
		SpringApplication.run(CloudEurekaServerApp.class, args);
	}
}
