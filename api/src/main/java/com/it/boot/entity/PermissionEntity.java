package com.it.boot.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@ApiModel(value = "权限")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "permission")
@Entity(name = "permission")
@org.hibernate.annotations.Table(appliesTo = "permission", comment = "权限")
@Table(name = "permission",
        indexes = {
                @Index(columnList = "name", unique = true),
        }
)
public class PermissionEntity extends BaseEntity {
    @Column(nullable = false, columnDefinition = "varchar(64) COMMENT '权限名称'")
    @ApiModelProperty(value = "权限名称")
    private String name;
}

