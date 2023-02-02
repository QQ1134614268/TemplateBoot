package com.it.boot;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MockApiTest { // springboot 自带框架,, 测试本项目没有问题,,在微宝项目 ,,,不能运行
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @org.junit.Test
    public void test01() throws Exception { // springboot 带有的测试框架 ,, 上面代码 会在api测试开始前,构建测试需要的后台服务
        mockMvc.perform(MockMvcRequestBuilders.get("/api/all/hi").param("count", "110").param("message", "zero")
                .contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(MockMvcResultMatchers.status().isOk());
        // MockMvcRequestBuilders.get("/api/all/hi") 发起一个请求,,
        // "/api/all/hi",,代表向本服务发起一个url为 localhost:该应用配置的端口/api/all/hi 的请求
        // param("count", "110"),设置参数,可以循环添加参数
        // contentType(MediaType.APPLICATION_JSON_UTF8) 设置发起请求的编码,即告诉后台编码格式
        // andExpect(MockMvcResultMatchers.status().isOk()) andExpect 期望某个结果,不为true
        // 抛出异常,,,
        // MockMvcResultMatchers.status().isOk() status值为200 其他值为异常
    }

    @org.junit.Test
    public void testView2() {
        // 第二个接口测试

    }

}