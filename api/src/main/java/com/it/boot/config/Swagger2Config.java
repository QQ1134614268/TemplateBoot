package com.it.boot.config;

import com.it.boot.config.Conf;
import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
// @Profile({"dev", "test"})
public class Swagger2Config {
    @Bean
    public Docket docket() {
        // 1. apiInfo
        Contact author = new Contact("boot", "https://it.com", "boot@it.com");
        List<VendorExtension> list = Collections.singletonList(new StringVendorExtension("w_name", "w_value"));
        ApiInfo apiInfo = new ApiInfo("项目Swagger文档", "Swagger描述", "1.0", "https://teamOfService.com", author, "Apache 2.0", "https://www.apache.org/licenses/LICENSE-2.0", list);

        // 2. 全局token认证
        ApiKey o = new ApiKey("token认证信息", Conf.AUTHORIZATION, ParameterType.HEADER.name());
        List<SecurityScheme> securitySchemes = Collections.singletonList(o);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                // .globalRequestParameters(globalPara) // 全局参数
                .securitySchemes(securitySchemes)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class)) // 指定扫描的接口
                .build();
    }
}