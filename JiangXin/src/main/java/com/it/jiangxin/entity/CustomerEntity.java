package com.it.jiangxin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;

@ApiModel(value = "客户")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "customer")
@Entity(name = "customer")
@Table(appliesTo = "customer", comment = "客户")
public class CustomerEntity extends BaseEntity {
    @ApiModelProperty(value = "用户名", example = "test_1", required = true)
    @Column(unique = true, nullable = false, columnDefinition = "varchar(255) COMMENT '客户名'")
    private String name;
    @ApiModelProperty(value = "面积", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '面积'")
    private Integer area;
    @ApiModelProperty(value = "手机号码", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '手机号码'")
    private String phone;
    @ApiModelProperty(value = "状态", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '状态'")
    private Integer styleId;
}