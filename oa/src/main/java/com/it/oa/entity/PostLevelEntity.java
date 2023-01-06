package com.it.oa.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;

@ApiModel(value = "人事管理/职位管理/职级管理")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "post_level")
@Entity(name = "post_level")
@Table(appliesTo = "post_level", comment = "人事管理/职位管理/职级管理")
public class PostLevelEntity extends BaseEntity {
    @ApiModelProperty(value = "职级类别id", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '职级类别id'")
    private Integer postLevelTypeId;
    @ApiModelProperty(value = "职级名称", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '职级名称'")
    private String postLevelName;
    @ApiModelProperty(value = "职级别名", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '职级别名'")
    private String nameAlias;
    @ApiModelProperty(value = "描述描述", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '描述描述'")
    private String description;
}