package com.it.jiangxin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "img_label_relation")
@Entity(name = "img_label_relation")
@Table(appliesTo = "img_label_relation", comment = "图片标签关联表")
@Schema(name = "图片标签关联表")
public class ImgLabelRelationEntity extends BaseEntity {

    @Schema(name = "值", example = "test_1")
    @Column(columnDefinition = "varchar(255) COMMENT '翻译标签'")
    private String labelId;

}