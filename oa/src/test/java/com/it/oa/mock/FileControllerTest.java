package com.it.oa.mock;

import com.google.gson.Gson;
import com.it.oa.config.ApiResult;
import com.it.oa.controller.FileController;
import com.it.oa.util.GetClassUtil;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Objects;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
public class FileControllerTest {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;  // undo @Autowired

    Gson object = new Gson();

    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void upload2() throws Exception {
        upload();
    }

    public ApiResult upload() throws Exception {
        String filePath = Objects.requireNonNull(this.getClass().getResource("/test.png")).getPath();
        File file = new File(filePath);
        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", // 文件名
                file.getName(), // originalName 相当于上传文件在客户机上的文件名
                MediaType.IMAGE_JPEG_VALUE, // 文件类型
                Files.newInputStream(file.toPath()) // 文件流
        );

        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();// 调用的方法名
        String url = GetClassUtil.getControllerUrl(FileController.class) + "/" + methodName;
        ResultActions resultActions = this.mockMvc.perform(multipart(url).file(mockMultipartFile));
        // resultActions.andReturn()
        resultActions.andExpect(status().isOk()).andReturn().getResponse().setCharacterEncoding(StandardCharsets.UTF_8.name());
        ApiResult res = object.fromJson(resultActions.andReturn().getResponse().getContentAsString(), ApiResult.class);
        Assertions.assertEquals(1, res.getCode());
        return res;
    }

    @Test
    public void download() throws Exception {
        ApiResult res = upload();
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();// 调用的方法名
        String url = GetClassUtil.getControllerUrl(FileController.class) + "/" + methodName;
        url += "/" + res.getData();
        ResultActions resultActions = mockMvc.perform(get(url));
        resultActions.andExpect(status().isOk());
        if (Objects.equals(resultActions.andReturn().getResponse().getContentType(), "application/json")) {
            ApiResult res2 = object.fromJson(resultActions.andReturn().getResponse().getContentAsString(), ApiResult.class);
            Assertions.assertEquals(1, res2.getCode());
        }
    }
}

