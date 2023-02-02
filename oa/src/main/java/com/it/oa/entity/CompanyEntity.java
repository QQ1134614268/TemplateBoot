package com.it.oa.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;

@ApiModel(value = "系统管理/企业设置/企业信息")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "company")
@Entity(name = "company")
@Table(appliesTo = "company", comment = "系统管理/企业设置/企业信息")
public class CompanyEntity extends BaseEntity {
    @ApiModelProperty(value = "企业简称", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '企业简称'")
    private String shortName;
    @ApiModelProperty(value = "企业全称", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '企业全称'")
    private String companyName;
    @ApiModelProperty(value = "企业logo", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '企业logo'")
    private String logo;
    @ApiModelProperty(value = "联系电话", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '联系电话'")
    private String phone;
    @ApiModelProperty(value = "所在省份", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '所在省份'")
    private String province;
    @ApiModelProperty(value = "所在城市", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '所在城市'")
    private String city;
    @ApiModelProperty(value = "所在城市", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '所在县区'")
    private String area;
    @ApiModelProperty(value = "详细地址", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '详细地址'")
    private String address;
    @ApiModelProperty(value = "企业状态", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '企业状态'")
    private String status;
    @ApiModelProperty(value = "创建人", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '创建人'")
    private String creator;
}