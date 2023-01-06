package com.it.boot.controller.test_aop.cglib;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(tags = "测试/CglibProxyController")
@Slf4j
@RestController
@RequestMapping("/api/CglibProxyController")
public class CglibProxyController {
    // 直接用Chinese类注入
    @Resource
    private Chinese chinese;

    // http://127.0.0.1:9091/test
    @ApiOperation(value = "test")
    @GetMapping("/test")
    public String test() {
        chinese.sayHello("listen");
        System.out.println(chinese.getClass());
        //    class com.it.controller.testaop.cglib.Chinese
        return "hello";
    }

}