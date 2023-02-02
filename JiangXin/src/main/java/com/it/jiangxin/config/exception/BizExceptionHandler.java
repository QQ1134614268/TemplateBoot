package com.it.jiangxin.config.exception;

import com.it.jiangxin.config.ApiResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class BizExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(BizExceptionHandler.class);
    private static final String msg = "系统异常:";

    @Resource
    private HttpServletRequest request;


    @ExceptionHandler(BizException.class)
    public ApiResult<String> handleOaGlobalException(BizException e) {
        log.error(msg + e.getMessage(), e);
        return ApiResult.fail("请求错误: " + e.getMessage());
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ApiResult<String> handle404Exception(NoHandlerFoundException e, HttpServletRequest request) {
        log.error(msg + e.getMessage(), e);
        return ApiResult.fail("接口路径错误: " + e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ApiResult<String> handleException(Exception e) {
        log.error(msg + e.getMessage(), e);// 异常信息
        return ApiResult.fail("服务器发生异常:" + e.getMessage());
    }
}
