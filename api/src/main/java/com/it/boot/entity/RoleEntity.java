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

@ApiModel(value = "角色")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "role")
@Entity(name = "role")
@org.hibernate.annotations.Table(appliesTo = "role", comment = "角色")
@Table(name = "role",
        indexes = {
                @Index(columnList = "name", unique = true),
        }
)
public class RoleEntity extends BaseEntity {
    @Column(unique = false, nullable = false, columnDefinition = "varchar(64) COMMENT '角色名称'")
    @ApiModelProperty(value = "角色名称")
    private String name;
}

