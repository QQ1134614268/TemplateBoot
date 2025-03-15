package com.it.feign;

import com.it.feign.api.RemoteExampleService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FallbackTest {

    @Resource
    private RemoteExampleService remoteExampleService;

    @Test
    public void testFallback() {
        // 模拟服务调用失败 404（例如，服务返回 404, 5xx 错误）
        int response = remoteExampleService.service404();
        // 验证 Fallback 是否被执行
        assertEquals(-1, response);
    }
}