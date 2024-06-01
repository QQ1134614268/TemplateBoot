package com.it.boot.controller.test_aop.jdk;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Tag(name = "测试/JdkProxyController")
@RestController
@RequestMapping("/api/JdkProxyController")
public class JdkProxyController {
    // 这里必须使用Person接口做注入
    @Resource
    private Person chinese2;

    // http://127.0.0.1:9091/test
    @GetMapping("/test")
    @Operation(summary = "test")
    public String test() {
        chinese2.sayHello("listen");
        System.out.println(chinese2.getClass());
        //    class com.it.controller.aop.jdk.Chinese$$EnhancerBySpringCGLIB$$37116899
        return "hello";
    }

}