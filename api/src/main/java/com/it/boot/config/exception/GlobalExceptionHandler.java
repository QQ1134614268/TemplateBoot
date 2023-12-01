package com.it.boot.config.exception;

import com.it.boot.config.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ApiResult<String> handleException(Exception e) {
        log.error("全局异常", e);// 异常信息
        // log.info("Exception" + e.getMessage()); e.getMessage() 异常类型
        // e.printStackTrace();// 红色 异常信息
        return ApiResult.fail("服务器发生异常: " + e.getMessage());
    }

    @ExceptionHandler(BizException.class)
    public ApiResult<String> handle404Exception(BizException e) {
        log.error("全局异常", e);
        return ApiResult.fail("服务器发生异常: " + e.getMessage());
    }

}
