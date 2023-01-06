package com.it.oa.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;

@ApiModel(value = "客户管理/客户列表/客户联系人")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "customer_contact")
@Entity(name = "customer_contact")
@Table(appliesTo = "customer_contact", comment = "客户管理/客户列表/客户联系人")
public class CustomerContactEntity extends BaseEntity {
    @ApiModelProperty(value = "客户Id", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '客户Id'")
    private Integer customerId;
    @ApiModelProperty(value = "联系人姓名", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '联系人姓名'")
    private String contactName;
    @ApiModelProperty(value = "性别", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '性别'")
    private String sex;
    @ApiModelProperty(value = "联系人电话", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '联系人电话'")
    private String contactPhone;
    @ApiModelProperty(value = "联系人性别", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '联系人性别'")
    private String contactEmail;
    @ApiModelProperty(value = "联系人职位", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '联系人职位'")
    private String contactPost;
}