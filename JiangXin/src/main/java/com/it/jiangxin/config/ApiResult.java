package com.it.jiangxin.config;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(name = "api返回对象")
@Data
public class ApiResult<T> {
    public final static int Success = 1;
    public final static int Failure = 2;
    public final static int Forbidden = 3;

    @Schema(name = "请求结果状态码", example = "1")
    private int code;
    @Schema(name = "返回数据", example = "")
    private T data;
    @Schema(name = "请求异常时信息", example = "")
    private String message;

    public static <T> ApiResult<T> success(T data) {
        // if (data instanceof IPage) {
        //     return success(((IPage<?>) data).getRecords(), ((IPage<?>) data).getTotal());
        // }
        ApiResult<T> res = new ApiResult<>();
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

    // public static <T> ApiResult<T> success(T data, Long total) {
    //     ApiResult res = new ApiResult();
    //     res.code = Success;
    //     res.data = data;
    //     // res.total = total;
    //     return res;
    // }

    public static <T> ApiResult<T> fail(String message) {
        ApiResult<T> res = new ApiResult<>();
        res.code = Failure;
        res.message = message;
        return res;
    }

    public static <T> ApiResult<T> forbidden(String message) {
        ApiResult<T> res = new ApiResult<>();
        res.code = Forbidden;
        res.message = message;
        return res;
    }

    public boolean isSuccess() {
        return this.code == Success;
    }

    public boolean isError() {
        return !isSuccess();
    }
}
