package com.it.oa.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;

@ApiModel(value = "系统管理/企业设置/素材管理")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "material")
@Entity(name = "material")
@Table(appliesTo = "material", comment = "系统管理/企业设置/素材管理")
public class MaterialEntity extends BaseEntity {
    @ApiModelProperty(value = "分类id", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '分类id'")
    private Integer parentId;
    @ApiModelProperty(value = "图片名", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '图片名'")
    private String imgName;
    @ApiModelProperty(value = "图片地址", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '图片地址'")
    private String imgPath;
}