package com.it.jiangxin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;

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
    @Column( columnDefinition = "int(11) COMMENT '面积'")
    private Double area;
    @Schema(name = "手机号码", example = "test_1")
    @Column( columnDefinition = "varchar(255) COMMENT '手机号码'")
    private String phone;
    @Schema(name = "风格id", example = "1")
    @Column( columnDefinition = "int(11) COMMENT '状态'")
    private Integer styleId;
}