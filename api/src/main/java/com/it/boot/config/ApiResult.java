package com.it.boot.config;

import com.it.boot.config.enum1.CodeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(name = "api返回对象")
@Data
public class ApiResult<T> {
    /**
     * @see CodeEnum
     */
    @Schema(name = "请求结果状态码", example = "1")
    private int code;
    @Schema(name = "返回数据")
    private T data;
    @Schema(name = "请求异常时信息")
    private String message;

    public static <T> ApiResult<T> success(T data) {
        ApiResult<T> res = new ApiResult<>();
        res.code = CodeEnum.SUCCESS.getCode();
        res.data = data;
        return res;
    }

    public static <T> ApiResult<T> success() {
        ApiResult<T> res = new ApiResult<>();
        res.code = CodeEnum.SUCCESS.getCode();
        res.data = null;
        return res;
    }

    public static <T> ApiResult<T> fail(String message) {
        ApiResult<T> res = new ApiResult<>();
        res.code = CodeEnum.FAILURE.getCode();
        res.message = message;
        return res;
    }

    public boolean isSuccess() {
        return this.code == CodeEnum.SUCCESS.getCode();
    }

    public boolean isError() {
        return !isSuccess();
    }
}
