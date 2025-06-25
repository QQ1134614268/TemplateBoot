package com.it.springdoc.entity;


import com.it.springdoc.config.StatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(defaultValue = "用户")
@Data
@EqualsAndHashCode(callSuper = true)
public class UserEntity extends BaseEntity {
    @Schema(description = "用户名")
    private String userName;
    @Schema(description = "密码")
    private String password;
    @Schema(description = "状态", implementation = StatusEnum.class)
    private StatusEnum statusEnum;
}