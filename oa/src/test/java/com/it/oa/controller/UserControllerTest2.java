package com.it.oa.controller;

import com.it.oa.config.ApiResult;
import com.it.oa.entity.UserEntity;
import com.it.oa.util.BuildDataUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
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

/**
 * 权限认证后调用接口
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
public class UserControllerTest2 {

    @Resource
    private org.apache.shiro.mgt.SecurityManager securityManager;
    @Resource
    private WebApplicationContext webApplicationContext;
    @Resource
    UserController userController;
    private Subject subject;
    private MockMvc mockMvc;
    private MockHttpServletRequest mockHttpServletRequest;
    private MockHttpServletResponse mockHttpServletResponse;


    // 用户登录
    private void login(String username, String password) {
        subject = new WebSubject.Builder(mockHttpServletRequest, mockHttpServletResponse).buildWebSubject();
        // 用户密码
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, false);
        // 基于JWT令牌验证
        // String token = JwtUtil.sign(username, password);
        // redisUtil.set(CommonConstant.PREFIX_USER_TOKEN + token, token);  // 设置超时时间
        // JwtToken jwtToken = new JwtToken(token);
        subject.login(token);
        ThreadContext.bind(subject);
    }

    // 初始化上下文
    @BeforeEach
    void beforeTest() {
        mockHttpServletRequest = new MockHttpServletRequest(webApplicationContext.getServletContext());
        mockHttpServletResponse = new MockHttpServletResponse();
        MockHttpSession mockHttpSession = new MockHttpSession(webApplicationContext.getServletContext());
        mockHttpServletRequest.setSession(mockHttpSession);
        SecurityUtils.setSecurityManager(securityManager);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        login("test", "test");
    }

    // 业务方法
    @Test
    public void insert() {
        UserEntity userEntity = BuildDataUtil.createData(UserEntity.class);
        userEntity.setId(null);
        // UserEntity userEntity =new UserEntity();
        // userEntity.setUserName(getRandomString());
        // userEntity.setPassword(getRandomString());
        ApiResult res = userController.create(userEntity);
        Assertions.assertEquals(1, res.getCode());
    }
}

