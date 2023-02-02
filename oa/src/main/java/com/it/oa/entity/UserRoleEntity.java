package com.it.oa.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;

@ApiModel(value = "用户角色")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "user_role")
@Entity(name = "user_role")
@Table(appliesTo = "user_role", comment = "用户角色")
public class UserRoleEntity extends BaseEntity {
    @ApiModelProperty(value = "用户id", example = "1584866657", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '用户id'")
    private Integer userId;
    @ApiModelProperty(value = "角色Id", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '角色Id'")
    private Integer roleId;
    @ApiModelProperty(value = "状态", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "bit(1) default true COMMENT '状态'")
    private Boolean isUse;
}