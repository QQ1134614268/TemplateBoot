package com.it.jpa;

import com.it.jpa.entity.UserEntity;
import com.it.jpa.controller.UserJpaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class JpaApplicationTests {

    @Resource
    private UserJpaRepository userJpaRepository;

    @Test
    public void test_0_create() {
        UserEntity entity = new UserEntity();
        entity.setNickName("1");
        UserEntity res = userJpaRepository.save(entity);
        Assertions.assertNotNull(res.getId());
    }
}
