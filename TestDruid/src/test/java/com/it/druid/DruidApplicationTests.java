package com.it.druid;

import com.it.druid.entity.UserEntity;
import com.it.druid.controller.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class DruidApplicationTests {

    @Resource
    private UserService userService;

    @Test
    public void test_0_create() {
        UserEntity entity = new UserEntity();
        entity.setUsername("1");
        boolean res = userService.save(entity);
        Assertions.assertTrue(res);
    }
}
