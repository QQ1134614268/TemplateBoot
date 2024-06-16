package com.it.jiangxin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class JiangxinApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(JiangxinApplication.class);
        Environment env = app.run(args).getEnvironment();
        System.out.println(String.format("http://127.0.0.1:%s/doc.html", env.getProperty("server.port")));
    }
}
