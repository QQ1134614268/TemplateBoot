package com.it.jiangxin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class JiangxinApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(JiangxinApplication.class);
        Environment env = app.run(args).getEnvironment();
        System.out.printf("http://%s:%s/doc.html%n", env.getProperty("serverHost"), env.getProperty("server.port"));
    }
}
