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

@Schema(name = "客户")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "customer")
@Entity(name = "customer")
@Table(appliesTo = "customer", comment = "客户")
public class CustomerEntity extends BaseEntity {
    @Schema(name = "用户名", example = "test_1")
    @Column(unique = true, nullable = false, columnDefinition = "varchar(255) COMMENT '客户名'")
    private String name;
    @Schema(name = "面积", example = "1")
    @Column(columnDefinition = "int(11) COMMENT '面积'")
    private Double area;
    @Schema(name = "手机号码", example = "test_1")
    @Column(columnDefinition = "varchar(255) COMMENT '手机号码'")
    private String phone;
    @Schema(name = "风格id", example = "1")
    @Column(columnDefinition = "int(11) COMMENT '风格id'")
    private Integer styleId;
    @Transient
    @TableField(exist = false)
    @Schema(name = "分类名称", example = "test_1")
    private String styleName;
    @Schema(name = "风格id", example = "1")
    @Column(columnDefinition = "int(11) COMMENT '进度'")
    private Integer process;
    @Schema(name = "风格id", example = "1")
    @Column(columnDefinition = "int(11) COMMENT '责任人id'")
    private Integer headId;
}