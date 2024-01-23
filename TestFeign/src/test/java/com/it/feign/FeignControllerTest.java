package com.it.feign;

import com.it.feign.controller.FeignController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
public class FeignControllerTest {
    @Resource
    private FeignController feignController;

    @Test
    public void test() {
        feignController.getRemoteSum();
        feignController.getRemoteTextPlain();
        feignController.contentType();
    }

    @Test
    public void helloHttps() {
        feignController.helloHttps();
    }
}