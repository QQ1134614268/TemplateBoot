package com.it.jiangxin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Schema(name = "分组设置")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "img")
@Entity(name = "img")
@Table(appliesTo = "img", comment = "图片")
public class ImgEntity extends BaseEntity {
    @Schema(name = "一组的uuid", example = "0")
    @Column(columnDefinition = "varchar(64) COMMENT '一组的uuid'")
    private String groupUuid;

    @Schema(name = "图片地址", example = "test_1")
    @Column(columnDefinition = "varchar(128) COMMENT '图片地址'")
    private String imgUrl;

    @Schema(name = "描述", example = "test_1")
    @Column(columnDefinition = "varchar(64) COMMENT '描述'")
    private String description;

    @Schema(name = "父级id", example = "0")
    @Column(columnDefinition = "int(1) COMMENT '是否为首页图片'")
    private Boolean isHomeImg;

    @Schema(name = "首页名", example = "test_1")
    @Column(columnDefinition = "varchar(64) COMMENT '首页名'")
    private String name;

    @Schema(name = "风格id", example = "1")
    @Column(columnDefinition = "int(11) COMMENT '分类id'")
    private Integer styleId;

    @Transient
    @TableField(exist = false)
    @Schema(name = "分类名称", example = "test_1")
    private String styleName;
}
