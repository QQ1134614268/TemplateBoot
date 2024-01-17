package com.it.boot;


import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeEach;
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
public class MockApiTest2 {

    @Resource
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @BeforeEach
    void beforeTest() {
        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest(webApplicationContext.getServletContext());
        MockHttpSession mockHttpSession = new MockHttpSession(webApplicationContext.getServletContext());

        MockHttpServletResponse mockHttpServletResponse = new MockHttpServletResponse();
        mockHttpServletRequest.setSession(mockHttpSession);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        // SecurityUtils.setSecurityManager(securityManager);
        // Subject subject = new WebSubject.Builder(mockHttpServletRequest, mockHttpServletResponse).buildWebSubject();
        //
        // ThreadContext.bind(subject);
    }
}