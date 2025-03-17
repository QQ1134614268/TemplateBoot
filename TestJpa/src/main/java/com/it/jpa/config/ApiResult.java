package com.it.jpa.config;

import lombok.Data;

@Data
public class ApiResult<T> {
    /**
     * @see ResCodeEnum
     */
    private int code;
    private T data;
    private String message;

    public static <T> ApiResult<T> success(T data) {
        ApiResult<T> res = new ApiResult<>();
        res.code = ResCodeEnum.SUCCESS.getCode();
        res.data = data;
        return res;
    }

    public static <T> ApiResult<T> success() {
        ApiResult<T> res = new ApiResult<>();
        res.code = ResCodeEnum.SUCCESS.getCode();
        res.data = null;
        return res;
    }

    public static <T> ApiResult<T> fail(String message) {
        ApiResult<T> res = new ApiResult<>();
        res.code = ResCodeEnum.FAILURE.getCode();
        res.message = message;
        return res;
    }

    public boolean isSuccess() {
        return this.code == ResCodeEnum.SUCCESS.getCode();
    }

    public boolean isError() {
        return !isSuccess();
    }
}
