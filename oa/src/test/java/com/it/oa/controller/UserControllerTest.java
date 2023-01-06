package com.it.oa.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.oa.config.ApiResult;
import com.it.oa.controller.para.UserParam;
import com.it.oa.entity.UserEntity;
import com.it.oa.util.BuildDataUtil;
import com.it.oa.util.VerificationCodeUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ThreadContext;
import org.apache.shiro.web.subject.WebSubject;
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
    private UserController userController;
    UserEntity userEntity = BuildDataUtil.createData(UserEntity.class);
    Page<UserEntity> page = new Page<>(1, 10);
    @Resource
    private org.apache.shiro.mgt.SecurityManager securityManager;

    @Resource
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    void beforeTest() {
        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest(webApplicationContext.getServletContext());
        MockHttpSession mockHttpSession = new MockHttpSession(webApplicationContext.getServletContext());

        MockHttpServletResponse mockHttpServletResponse = new MockHttpServletResponse();
        mockHttpServletRequest.setSession(mockHttpSession);
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = new WebSubject.Builder(mockHttpServletRequest, mockHttpServletResponse).buildWebSubject();

        ThreadContext.bind(subject);
    }

    @Test
    public void test_0_create() {
        ApiResult res = userController.create(userEntity);
        Assertions.assertEquals(1, res.getCode());
    }

    @Test
    public void test_1_getPage() {
        // ApiResult res = userController.getPage(page, userEntity);
        // Assertions.assertEquals(1, res.getCode());
    }


    @Test
    public void test_2_updateById() {
        ApiResult res = userController.updateById(userEntity);
        Assertions.assertEquals(1, res.getCode());
    }

    // @Test
    // public void test_3_deleteById() {
    //     Integer id = 1;
    //     ApiResult res = userController.deleteById(id);
    //     Assertions.assertEquals(1, res.getCode());
    // }
    //
    // @Test
    // public void test_4_deleteByIds() {
    //     Integer[] idList = {1};
    //     ApiResult res = userController.deleteByIds(Arrays.asList(idList));
    //     Assertions.assertEquals(1, res.getCode());
    // }

    @Test
    public void login() {
        String text = VerificationCodeUtil.randomText();
        userController.verificationCodeToRedis(text);
        // stringRedisTemplate.
        UserParam user = new UserParam();
        user.setUserName("test");
        user.setPassword("test");
        user.setPassword(text);
        ApiResult res = userController.login(user);
        Assertions.assertEquals(1, res.getCode());
    }

    @Test
    public void logout() {
        userController.logout();
    }

}