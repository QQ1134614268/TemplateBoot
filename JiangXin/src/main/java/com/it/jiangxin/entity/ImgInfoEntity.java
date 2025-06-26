package com.it.jiangxin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;

@Schema(title = "分组设置")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "img_info")
@Entity(name = "img_info")
@Table(appliesTo = "img_info", comment = "图片详情")
public class ImgInfoEntity extends BaseEntity {

    @Schema(title = "关联imgId", example = "test_1")
    @Column(columnDefinition = "int COMMENT '关联imgId'")
    private Integer imgId;

    @Schema(title = "图片地址", example = "test_1")
    @Column(columnDefinition = "varchar(128) COMMENT '图片地址'")
    private String imgUrl;

    @Schema(title = "描述", example = "test_1")
    @Column(columnDefinition = "varchar(64) COMMENT '描述'")
    private String description;
}
