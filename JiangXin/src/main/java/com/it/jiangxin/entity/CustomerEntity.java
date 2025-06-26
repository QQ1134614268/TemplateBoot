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

@Schema(title = "客户")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "customer")
@Entity(name = "customer")
@Table(appliesTo = "customer", comment = "客户")
public class CustomerEntity extends BaseEntity {
    @Schema(title = "用户名", example = "test_1")
    @Column(columnDefinition = "varchar(255) COMMENT '客户名'")
    private String name;
    @Schema(title = "面积", example = "1")
    @Column(columnDefinition = "int(11) COMMENT '面积'")
    private Double area;
    @Schema(title = "手机号码", example = "test_1")
    @Column(columnDefinition = "varchar(255) COMMENT '手机号码'")
    private String phone;
    @Schema(title = "风格", example = "中式")
    @Column(columnDefinition = "varchar(255) COMMENT '风格'")
    private String style;
    @Schema(title = "装修类型", example = "毛坯新房")
    @Column(columnDefinition = "varchar(255) COMMENT '装修类型'")
    private String house;
    @Transient
    @TableField(exist = false)
    @Schema(title = "分类名称", example = "test_1")
    private String styleName;
    @Schema(title = "风格id", example = "1")
    @Column(columnDefinition = "int(11) COMMENT '进度'")
    private Integer process;
    @Schema(title = "风格id", example = "1")
    @Column(columnDefinition = "int(11) COMMENT '责任人id'")
    private Integer headId;
}