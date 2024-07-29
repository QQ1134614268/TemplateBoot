package com.it.feign.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 测试feignClient, 避免多个注入表达式, 若修改仅需修改此处注入表达式
 */
@Data
@Component
public class PropConfig {
    @Value("${TestFeign.sumService.url}")
    private String url;
    @Value("${TestFeign.sumService.sumPath}")
    private String path;
}
