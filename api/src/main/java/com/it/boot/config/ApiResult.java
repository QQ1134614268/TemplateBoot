package com.it.boot.config;

import com.it.boot.config.enumeration.ResCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("api返回对象")
@Data
public class ApiResult<T> {

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
        res.code = ResCodeEnum.RES_SUCCESS.getCode();
        res.data = data;
        return res;
    }

    public static <T> ApiResult<T> success() {
        ApiResult<T> res = new ApiResult<>();
        res.code = ResCodeEnum.RES_SUCCESS.getCode();
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
        res.code = ResCodeEnum.RES_FAILURE.getCode();
        res.message = message;
        return res;
    }
    public boolean isSuccess() {
        return  getCode() == ResCodeEnum.RES_SUCCESS.getCode();
    }
    public boolean isError() {
        return !isSuccess();
    }
}
