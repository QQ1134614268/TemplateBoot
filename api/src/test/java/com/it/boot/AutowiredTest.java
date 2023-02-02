package com.it.boot;

import com.it.boot.controller.test.HelloController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest // 表明这是SpringBootTest
// ,,@RunWith(SpringRunner.class)@SpringBootTest将会在单元测试中提起后台服务(类似启动后台服务)
public class AutowiredTest {
    @Autowired
    private HelloController controller; // 注入一个Controller bean

    @Test
    public void test01() { // 使用注入方式 ,调用 Controller 的方法,,,此方法类似单元测试
        String string = controller.hello();
        Assert.assertEquals("hello world", string);
    }

    @Test
    public void configPort() {
        System.out.println(controller.configPort());
    }
}
