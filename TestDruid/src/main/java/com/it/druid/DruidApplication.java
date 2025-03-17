package com.it.druid;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@MapperScan({"com.gitee.sunchenbin.mybatis.actable.dao.*", "com.it.druid.mapper"})
@ComponentScan(basePackages = {"com.gitee.sunchenbin.mybatis.actable.manager.*"}, basePackageClasses = DruidApplication.class)
@SpringBootApplication
public class DruidApplication {
    public static void main(String[] args) {
        System.out.println("http://127.0.0.1:8080/druid");
        SpringApplication.run(DruidApplication.class, args);
    }
}
