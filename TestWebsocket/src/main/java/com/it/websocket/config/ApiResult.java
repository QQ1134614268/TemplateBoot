package com.it.websocket.config;

import lombok.Data;

@Data
public class ApiResult<T> {
    public final static int Success = 1;
    public final static int Failure = 2;

    private int code;
    private T data;
    private String message;

    public static <T> ApiResult<T> success(T data) {
        ApiResult<T> res = new ApiResult<T>();
        res.code = Success;
        res.data = data;
        return res;
    }

    public static <T> ApiResult<T> success() {
        ApiResult<T> res = new ApiResult<>();
        res.code = Success;
        res.data = null;
        return res;
    }

    public static <T> ApiResult<T> fail(String message) {
        ApiResult<T> res = new ApiResult<>();
        res.code = Failure;
        res.message = message;
        return res;
    }

}
