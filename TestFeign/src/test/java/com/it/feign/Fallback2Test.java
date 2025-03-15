package com.it.feign;

import com.it.feign.api.RemoteApiService;
import com.it.feign.config.ApiResult;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT) // 使用 LenientStubs 模式, 放宽限制
public class Fallback2Test {

    @MockBean
    private RemoteApiService remoteApiService;

    @Test
    public void testFallback() {
        // 模拟服务调用失败 404（例如，服务返回 404, 5xx 错误）
        when(remoteApiService.sum(1,2)).thenThrow(new RuntimeException("test -- Exception"));

        ApiResult<Integer> response = remoteApiService.sum(1, 2); // 直接抛出异常, 不能进入fallback

        assertEquals(-1, response.getData());
    }
}