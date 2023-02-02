package com.it.oa.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;

@ApiModel(value = "个人办公/办公中心/云文件")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "cloud_file")
@Entity(name = "cloud_file")
@Table(appliesTo = "cloud_file", comment = "个人办公/办公中心/云文件")
public class CloudFileEntity extends BaseEntity {
    @ApiModelProperty(value = "文件名", example = "test_1", required = true)
    @Column(unique = false, nullable = false, columnDefinition = "varchar(255) COMMENT '文件名'")
    private String fileName;
    @ApiModelProperty(value = "是否是文件夹", example = "72260227", required = true)
    @Column(unique = false, nullable = false, columnDefinition = "bit(1) COMMENT '是否是文件夹'")
    private Boolean isDic;
    @ApiModelProperty(value = "文件类型", example = "test_1", required = true)
    @Column(unique = false, nullable = false, columnDefinition = "varchar(255) COMMENT '文件类型'")
    private String type;
    @ApiModelProperty(value = "文件大小", example = "10", required = true)
    @Column(unique = false, nullable = false, columnDefinition = "bigint(255) COMMENT '文件大小'")
    private Long fileSize;
    @ApiModelProperty(value = "文件位置", example = "test_1", required = true)
    @Column(unique = false, nullable = false, columnDefinition = "varchar(255) COMMENT '文件位置'")
    private String filePath;
    @ApiModelProperty(value = "父级文件夹id", example = "1", required = true)
    @Column(unique = false, nullable = false, columnDefinition = "int(11) COMMENT '父级文件夹id'")
    private Integer parentId;
    @ApiModelProperty(value = "是否删除", example = "false", required = true)
    @Column(unique = false, nullable = false, columnDefinition = "bit(1) COMMENT '是否删除'")
    private Boolean isDelete;
}