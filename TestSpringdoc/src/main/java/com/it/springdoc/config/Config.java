package com.it.springdoc.config;

import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

// @Component
public class Config {
    @Bean
    public OpenApiCustomiser openApiCustomiser() {
        return openApi -> openApi.info(
                new Info().title("My API Title")
                        .version("v1.0.0")
                        .description("My API description")
        );
    }
}
