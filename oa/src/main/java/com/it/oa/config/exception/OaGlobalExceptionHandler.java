package com.it.oa.config.exception;

import com.google.gson.Gson;
import com.it.oa.config.ApiResult;
import com.it.oa.util.DateUtil;
import com.it.oa.util.JwtUtil;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@RestControllerAdvice
public class OaGlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(OaGlobalExceptionHandler.class);
    private static final String OA = "OA系统异常:";

    @Resource
    private HttpServletRequest request;


    @ExceptionHandler(OaGlobalException.class)
    public ApiResult handleOaGlobalException(OaGlobalException e) {
        log.error(OA + e.getMessage(), e);
        return ApiResult.fail("请求错误: " + e.getMessage());
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ApiResult handle404Exception(NoHandlerFoundException e, HttpServletRequest request) {
        log.error(OA + e.getMessage(), e);
        return ApiResult.fail("接口路径错误: " + e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ApiResult handleException(Exception e) {
        log.error(OA + e.getMessage(), e);// 异常信息
        return ApiResult.fail("服务器发生异常:" + e.getMessage());
    }
}
