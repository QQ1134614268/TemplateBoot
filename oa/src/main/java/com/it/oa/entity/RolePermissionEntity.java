package com.it.oa.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;

@ApiModel(value = "系统管理/系统设置/人员权限")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "role_permission")
@Entity(name = "role_permission")
@Table(appliesTo = "role_permission", comment = "系统管理/系统设置/人员权限")
public class RolePermissionEntity extends BaseEntity {
    @ApiModelProperty(value = "角色id", example = "877905367", required = true)
    @Column(unique = false, nullable = false, columnDefinition = "int(11) COMMENT '角色id'")
    private Integer roleId;
    @ApiModelProperty(value = "权限", example = "test_1", required = true)
    @Column(unique = false, nullable = false, columnDefinition = "varchar(255) COMMENT '权限'")
    private String permission;
}