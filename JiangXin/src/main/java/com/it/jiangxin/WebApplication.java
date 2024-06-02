package com.it.jiangxin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
        // SpringApplication app = new SpringApplication(WebApplication.class);
        // Environment env = app.run(args).getEnvironment();
        // System.out.println(env.getProperty("server.port"));
        System.out.println("http://127.0.0.1:29090/doc.html");
    }
}
