package com.it.jiangxin;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.jiangxin.config.ApiResult;
import com.it.jiangxin.config.enum1.AccountEnum;
import com.it.jiangxin.controller.UserController;
import com.it.jiangxin.entity.UserEntity;
import com.it.jiangxin.util.PasswordUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;


@SpringBootTest
public class UserControllerTest {

    @Resource
    private UserController userController;
    @Resource
    private Util util;
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
    public void test_0_create() throws IOException {
        String name = "test01";
        UserEntity user = new UserEntity();
        user.setUserName(name);
        user.setNickName(name);
        user.setPassword(PasswordUtil.desPassword(name));
        user.setAvatar(util.getUploadUrl("avtar.test.webp"));
        user.setPhone("188****1234");
        user.setStatus(AccountEnum.normal.value);
        user.setBirthDay(new Date());
        user.setCreate();
        ApiResult<Integer> res = userController.create(user);
        Assertions.assertEquals(1, res.getCode());
    }

    @Test
    public void test_1_getPage() {
        ApiResult<Page<UserEntity>> res = userController.getPage(Page.of(1, 10), new UserEntity());
        Assertions.assertEquals(1, res.getCode());
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
