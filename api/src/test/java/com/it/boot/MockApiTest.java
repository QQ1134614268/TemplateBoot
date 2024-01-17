package com.it.boot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

@SpringBootTest
public class MockApiTest {
    @Resource
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void test01() throws Exception { // springboot 带有的测试框架 ,, 上面代码 会在api测试开始前,构建测试需要的后台服务
        mockMvc.perform(MockMvcRequestBuilders.get("/api/HelloController/hello")
                .param("count", "110")
                .param("message", "zero")
                .contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(MockMvcResultMatchers.status().isOk());
        // MockMvcRequestBuilders.get("/api/HelloController/hello") 发起一个请求,,
        // "/api/HelloController/hello",,代表向本服务发起一个url为 localhost:该应用配置的端口/api/HelloController/hello 的请求
        // param("count", "110"),设置参数,可以循环添加参数
        // contentType(MediaType.APPLICATION_JSON_UTF8) 设置发起请求的编码,即告诉后台编码格式
        // andExpect(MockMvcResultMatchers.status().isOk()) andExpect 期望某个结果,不为true
        // 抛出异常,,,
        // MockMvcResultMatchers.status().isOk() status值为200 其他值为异常
    }
}