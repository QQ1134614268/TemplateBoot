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
@TableName(value = "imgInfo")
@Entity(name = "imgInfo")
@Table(appliesTo = "imgInfo", comment = "图片详情")
public class ImgInfoEntity extends BaseEntity {

    @Schema(name = "关联imgId", example = "test_1")
    @Column(columnDefinition = "int COMMENT '关联imgId'")
    private Integer imgId;

    @Schema(name = "图片地址", example = "test_1")
    @Column(columnDefinition = "varchar(128) COMMENT '图片地址'")
    private String imgUrl;

    @Schema(name = "描述", example = "test_1")
    @Column(columnDefinition = "varchar(64) COMMENT '描述'")
    private String description;
}
