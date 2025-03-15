package com.it.boot;

import com.it.boot.config.ApiResult;
import com.it.boot.controller.UserBatisController;
import com.it.boot.entity.UserEntity;
import com.it.boot.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AttMockTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserBatisController userBatisController;

    @Test
    public void testFallbackWithMock() {
        int arg = 1;
        UserEntity entity = new UserEntity();
        // 模拟服务调用
        // when(userService.getUserById(arg)).thenThrow(new RuntimeException("Service unavailable"));
        when(userService.getUserById(arg)).thenReturn(entity);

        // 调用 Fallback 方法
        ApiResult<UserEntity> response = userBatisController.testSelect(arg);

        // 验证 Fallback 是否被执行
        // assertEquals(ApiResult.success(new Object()), response);
        assertEquals(ApiResult.success(new UserEntity()), response);
    }
}