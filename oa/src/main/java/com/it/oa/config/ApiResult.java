package com.it.oa.config;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("api返回对象")
@Data
public class ApiResult<T> {
    public final static int Success = 1;
    public final static int Failure = 2;
    public final static int Forbidden = 3;

    @ApiModelProperty(value = "请求结果状态码", example = "1")
    private int code;
    @ApiModelProperty(value = "返回数据", example = "")
    private T data;
    @ApiModelProperty(value = "请求异常时信息", example = "")
    private String message;

    public static <T> ApiResult<T> success(T data) {
        // if (data instanceof IPage) {
        //     return success(((IPage<?>) data).getRecords(), ((IPage<?>) data).getTotal());
        // }
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

}
