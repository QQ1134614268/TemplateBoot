package com.it.oa.config.swagger;

import com.it.oa.config.ConstConf;
import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket docket(Environment environment) {
        // 1. 设置只在开发中环境中启动swagger,表示如果现在是dev环境，则返回true 开启swagger
        Profiles profiles = Profiles.of("dev", "test");
        boolean flag = environment.acceptsProfiles(profiles);

        // 2. apiInfo
        Contact author = new Contact("oa", "https://it.com", "oa@it.com");
        List<VendorExtension> list = Collections.singletonList(new StringVendorExtension("w_name", "w_value"));
        ApiInfo apiInfo = new ApiInfo("项目Swagger文档", "Swagger描述", "1.0", "https://teamOfService.com", author, "Apache 2.0", "https://www.apache.org/licenses/LICENSE-2.0", list);

        // 3. 全局token认证
        ApiKey o = new ApiKey("token认证信息", ConstConf.AUTHORIZATION, ParameterType.HEADER.name());
        List<SecurityScheme> securitySchemes = Collections.singletonList(o);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .enable(flag) // 是否启动swagger 默认启动
                // .globalRequestParameters(globalPara) // 全局参数
                .securitySchemes(securitySchemes)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class)) // 指定扫描的接口
                .build();
    }
}