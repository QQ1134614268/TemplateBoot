package com.cloud.base;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(name = "api返回对象")
@Data
public class ApiResult<T> {
    /**
     * @see ResCodeEnum
     */
    @Schema(name = "请求结果状态码", example = "1")
    private int code;
    @Schema(name = "返回数据")
    private T data;
    @Schema(name = "请求异常时信息")
    private String message;

    public static <T> ApiResult<T> success(T data) {
        ApiResult<T> res = new ApiResult<>();
        res.code = ResCodeEnum.SUCCESS.getValue();
        res.data = data;
        return res;
    }

    public static <T> ApiResult<T> success() {
        ApiResult<T> res = new ApiResult<>();
        res.code = ResCodeEnum.SUCCESS.getValue();
        res.data = null;
        return res;
    }

    public static <T> ApiResult<T> fail(String message) {
        ApiResult<T> res = new ApiResult<>();
        res.code = ResCodeEnum.FAILURE.getValue();
        res.message = message;
        return res;
    }

    public boolean isSuccess() {
        return this.code == ResCodeEnum.SUCCESS.getValue();
    }

    public boolean isError() {
        return !isSuccess();
    }
}
