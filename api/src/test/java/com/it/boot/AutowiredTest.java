package com.it.boot;

import com.it.boot.controller.TestHelloController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AutowiredTest {
    @Autowired
    private TestHelloController controller; // 注入一个Controller bean

    @Test
    public void test01() { // 使用注入方式 ,调用 Controller 的方法,,,此方法类似单元测试
        String string = controller.hello();
        Assertions.assertEquals("hello world!", string);
    }

    @Test
    public void configPort() {
        System.out.println(controller.configPort());
    }
}
