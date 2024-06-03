package com.it.jiangxin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Schema(name = "系统用户")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "user")
@Entity(name = "user")
@Table(appliesTo = "user", comment = "系统用户")
public class UserEntity extends BaseEntity {
    @Schema(name = "用户名", example = "test_1")
    @Column(unique = true, nullable = false, columnDefinition = "varchar(255) COMMENT '用户名'")
    private String userName;
    @Schema(name = "密码", example = "test_1")
    @Column( columnDefinition = "varchar(255) COMMENT '密码'")
    private String password;
    @Schema(name = "员工头像", example = "test_1")
    @Column( columnDefinition = "varchar(255) COMMENT '员工头像'")
    private String avatar;
    @Schema(name = "手机号码", example = "test_1")
    @Column( columnDefinition = "varchar(255) COMMENT '手机号码'")
    private String phone;
    @Schema(name = "昵称", example = "test_1")
    @Column(unique = true, columnDefinition = "varchar(255) COMMENT '昵称'")
    private String nickName;
    @Schema(name = "邮箱", example = "test_1")
    @Column( columnDefinition = "varchar(255) COMMENT '邮箱'")
    private String email;
    @Schema(name = "出生日期", example = "2020-10-10 00:00:00")
    @Column( columnDefinition = "datetime COMMENT '出生日期'")
    private Date birthDay;
    @Schema(name = "状态", example = "test_1")
    @Column( columnDefinition = "varchar(255) COMMENT '状态'")
    private String status;
}