package com.it.springdoc.entity;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(defaultValue = "用户")
@Data
@EqualsAndHashCode(callSuper = true)
public class UserEntity extends BaseEntity {
    @Schema(defaultValue = "用户名")
    private String userName;
    @Schema(defaultValue = "密码")
    private String password;
}