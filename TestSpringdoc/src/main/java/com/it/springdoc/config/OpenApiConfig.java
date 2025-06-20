package com.it.springdoc.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("TestSpringDoc--title")
                .description("TestSpringDoc--description ")
                .version("1.0.0")
            );
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("TestGroup--1") // 组名
                .pathsToMatch("/api/**") //限制只扫描项目中 /api/** 路径下的接口生成文档（避免暴露不必要的接口）
                .build();
    }
}