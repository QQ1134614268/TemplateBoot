package com.it.oa.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class TreeEntity extends BaseEntity {
    @ApiModelProperty(value = "父级id", example = "1", required = true)
    @Column(unique = false, nullable = false, columnDefinition = "int(11) COMMENT '父级id'")
    private Integer parentId;

    @ApiModelProperty(value = "文件名", example = "test_1", required = true)
    @Column(unique = false, nullable = false, columnDefinition = "varchar(255) COMMENT '文件名'")
    private String name;

}