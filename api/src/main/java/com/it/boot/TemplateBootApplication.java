package com.it.boot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;

@Slf4j
@EnableScheduling
@SpringBootApplication
public class TemplateBootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext application = SpringApplication.run(TemplateBootApplication.class, args);
        Environment env = application.getEnvironment();
        String port = env.getProperty("server.port");
        log.info("\n----------------------------------------------------------\n" +
                "\tSwagger文档: \thttp://127.0.0.1:" + port + "/doc.html\n" +
                "----------------------------------------------------------");
    }

}
