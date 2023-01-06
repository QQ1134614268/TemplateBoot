package com.it.oa.controller.para;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "登陆")
public class UserParam implements Serializable {
    @ApiModelProperty(value = "用户名", example = "test", required = true)
    private String userName;
    @ApiModelProperty(value = "密码", required = true)
    private String password;
    @ApiModelProperty(value = "验证码", required = true)
    private String verificationCode;
}
