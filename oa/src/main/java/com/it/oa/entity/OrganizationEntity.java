package com.it.oa.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;

@ApiModel(value = "人事管理/组织架构")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "organization")
@Entity(name = "organization")
@Table(appliesTo = "organization", comment = "人事管理/组织架构")
public class OrganizationEntity extends BaseEntity {
    @ApiModelProperty(value = "部门名称", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '部门名称'")
    private String orgName;
    @ApiModelProperty(value = "父级部门id", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '父级部门id'")
    private Integer parentId;
    @ApiModelProperty(value = "部门主管id", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '部门主管id'")
    private Integer leaderId;
    @ApiModelProperty(value = "部门介绍", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '部门介绍'")
    private String description;
    @ApiModelProperty(value = "组织顺序", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '组织顺序'")
    private Integer orgOrder;
}