package com.it.oa.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;

@ApiModel(value = "系统用户")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "system_user")
@Entity(name = "system_user")
@Table(appliesTo = "system_user", comment = "系统用户")
public class SystemUserEntity extends BaseEntity {
    @ApiModelProperty(value = "手机号码", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '手机号码'")
    private String phone;
    @ApiModelProperty(value = "密码", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '密码'")
    private String password;
}