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
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT) // 使用 LenientStubs 模式, 放宽限制
public class AttMockTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserBatisController userBatisController;

    @Test
    public void testFallbackWithMock() {
        int arg = 1;
        UserEntity entity = new UserEntity();
        // 模拟调用
        when(userService.getUserById(arg)).thenReturn(entity);

        ApiResult<UserEntity> response = userBatisController.testSelect(arg);

        // assertEquals(ApiResult.success(new Object()), response);
        assertEquals(ApiResult.success(new UserEntity()), response);
    }
}