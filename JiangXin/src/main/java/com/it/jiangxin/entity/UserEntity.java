package com.it.jiangxin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@ApiModel(value = "人事管理/员工档案")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "user")
@Entity(name = "user")
@Table(appliesTo = "user", comment = "人事管理/员工档案")
public class UserEntity extends BaseEntity {
    @ApiModelProperty(value = "用户名", example = "test_1", required = true)
    @Column(unique = true, nullable = false, columnDefinition = "varchar(255) COMMENT '用户名'")
    private String userName;
    @ApiModelProperty(value = "密码", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '密码'")
    private String password;
    @ApiModelProperty(value = "员工头像", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '员工头像'")
    private String avatar;
    @ApiModelProperty(value = "手机号码", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '手机号码'")
    private String phone;
    @ApiModelProperty(value = "身份证号", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '身份证号'")
    private String idCard;
    @ApiModelProperty(value = "性别", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '性别'")
    private String sex;
    @ApiModelProperty(value = "出生日期", example = "2020-10-10 00:00:00", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "datetime COMMENT '出生日期'")
    private Date birthDay;
    @ApiModelProperty(value = "状态", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '状态'")
    private String status;
}