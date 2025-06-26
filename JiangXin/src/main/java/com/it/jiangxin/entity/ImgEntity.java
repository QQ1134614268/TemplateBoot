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
import java.util.List;

@Schema(title = "分组设置")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "img")
@Entity(name = "img")
@Table(appliesTo = "img", comment = "图片")
public class ImgEntity extends BaseEntity {
    @Schema(title = "首页名", example = "test_1")
    @Column(columnDefinition = "varchar(64) COMMENT '首页名'")
    private String name;

    @Schema(title = "图片地址", example = "test_1")
    @Column(columnDefinition = "varchar(128) COMMENT '首页图片地址'")
    private String imgUrl;

    @Schema(title = "风格id", example = "1")
    @Column(columnDefinition = "int(11) COMMENT '分类id'")
    private Integer styleId;

    @Transient
    @TableField(exist = false)
    @Schema(title = "分类名称", example = "test_1")
    private String styleName;

    @Transient
    @TableField(exist = false)
    @Schema(title = "分类名称", example = "test_1")
    private List<ImgInfoEntity> children;

}
