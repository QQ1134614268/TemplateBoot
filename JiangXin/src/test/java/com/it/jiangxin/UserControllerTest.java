package com.it.jiangxin;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
public class UserControllerTest {

    @Resource
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    void beforeTest() {
        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest(webApplicationContext.getServletContext());
        MockHttpSession mockHttpSession = new MockHttpSession(webApplicationContext.getServletContext());

        MockHttpServletResponse mockHttpServletResponse = new MockHttpServletResponse();
        mockHttpServletRequest.setSession(mockHttpSession);
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        // SecurityUtils.setSecurityManager(securityManager);
        // Subject subject = new WebSubject.Builder(mockHttpServletRequest, mockHttpServletResponse).buildWebSubject();
        //
        // ThreadContext.bind(subject);
    }

    @Test
    public void test_0_create() {
        // ApiResult res = userController.create(userEntity);
        // Assertions.assertEquals(1, res.getCode());
    }

    @Test
    public void test_1_getPage() {
        // ApiResult res = userController.getPage(page, userEntity);
        // Assertions.assertEquals(1, res.getCode());
    }

    @Test
    public void login() {
        // String text = VerificationCodeUtil.randomText();
        // userController.verificationCodeToRedis(text);
        // // stringRedisTemplate.
        // UserParam user = new UserParam();
        // user.setUserName("test");
        // user.setPassword("test");
        // user.setPassword(text);
        // ApiResult res = userController.login(user);
        // Assertions.assertEquals(1, res.getCode());
    }

}