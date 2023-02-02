package com.it.oa.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;

@ApiModel(value = "系统管理/系统设置/角色管理")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "role")
@Entity(name = "role")
@Table(appliesTo = "role", comment = "系统管理/系统设置/角色管理")
public class RoleEntity extends BaseEntity {
    @ApiModelProperty(value = "身份名称", example = "-127623817", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '身份名称'")
    private String roleName;
    @ApiModelProperty(value = "启用状态", example = "-413844420", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "bit(1) COMMENT '启用状态'")
    private Boolean isUse;
    @ApiModelProperty(value = "菜单", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '菜单'")
    private String menus;
}