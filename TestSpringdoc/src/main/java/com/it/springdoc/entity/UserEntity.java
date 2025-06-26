package com.it.springdoc.entity;


import com.it.springdoc.config.StatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(title = "用户")
@Data
@EqualsAndHashCode(callSuper = true)
public class UserEntity extends BaseEntity {
    @Schema(title = "用户名", example = "example1")
    private String userName;
    @Schema(title = "密码")
    private String password;
    @Schema(title = "状态", implementation = StatusEnum.class)
    private StatusEnum statusEnum;
}