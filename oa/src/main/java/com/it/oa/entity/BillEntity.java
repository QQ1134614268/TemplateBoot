package com.it.oa.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.time.LocalDate;

@ApiModel(value = "客户管理/发票管理")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "bill")
@Entity(name = "bill")
@Table(appliesTo = "bill", comment = "客户管理/发票管理")
public class BillEntity extends BaseEntity {
    @ApiModelProperty(value = "合同id", example = "1", required = true)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '发票名称'")
    private Integer contractId;
    @Transient
    @TableField(exist = false)
    @ApiModelProperty(value = "合同名称", example = "1", required = true)
    private String contractName;
    @Transient
    @TableField(exist = false)
    @ApiModelProperty(value = "合同金额", example = "1", required = true)
    private BigDecimal contractMoney;
    @ApiModelProperty(value = "发票名称", example = "xx", required = true)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(32) COMMENT '发票名称'")
    private String billName;
    @ApiModelProperty(value = "开票日期", example = "Tue Jul 05 12:35:58 CST 2022", required = true)
    @Column(unique = false, nullable = true, columnDefinition = "date COMMENT '开票日期'")
    private LocalDate warnDate;
    @ApiModelProperty(value = "开票金额", example = "0.1", required = true)
    @Column(unique = false, nullable = true, columnDefinition = "decimal(19,4) default 0 COMMENT '开票金额'")
    private BigDecimal billMoney;
    @ApiModelProperty(value = "开票类型", example = "test_1", required = true)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '开票类型'")
    private String billType;
    @ApiModelProperty(value = "开票抬头", example = "test_1", required = true)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '开票抬头'")
    private String billHeader;
    @ApiModelProperty(value = "纳税人识别号", example = "test_1", required = true)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '纳税人识别号'")
    private String taxpayerNumber;
    @ApiModelProperty(value = "开户行", example = "test_1", required = true)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '开户行'")
    private String bankName;
    @ApiModelProperty(value = "开户账号", example = "test_1", required = true)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '开户账号'")
    private String bankNumber;
    @ApiModelProperty(value = "开票地址", example = "test_1", required = true)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '开票地址'")
    private String billAddress;
    @ApiModelProperty(value = "电话", example = "test_1", required = true)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '电话'")
    private String billPhone;

    @ApiModelProperty(value = "联系人", example = "test_1", required = true)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '联系人'")
    private String contactName;
    @ApiModelProperty(value = "联系人电话", example = "test_1", required = true)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '联系人电话'")
    private String phone;
    @ApiModelProperty(value = "邮寄方式", example = "test_1", required = true)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '邮寄方式'")
    private String mailType;
    @ApiModelProperty(value = "邮件/邮箱地址", example = "test_1", required = true)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '邮箱地址'")
    private String mail;
    @ApiModelProperty(value = "邮寄/收件地址", example = "test_1", required = true)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '邮箱地址'")
    private String address;
    @ApiModelProperty(value = "备注", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '备注'")
    private String note;
    @ApiModelProperty(value = "审核状态", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '审核状态'")
    private String checkStatus;
    @ApiModelProperty(value = "业务员id", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '业务员id'")
    private Integer salesmanId;

    @Transient
    @TableField(exist = false)
    @ApiModelProperty(value = "业务员", example = "test_1", required = false)
    private String salesman;

    @ApiModelProperty(value = "开票状态", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '审核状态'")
    private String status;

    @ApiModelProperty(value = "期望开票日期", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "date COMMENT '期望开票日期'")
    private LocalDate expectedBillingDate;

    @ApiModelProperty(value = "开票凭证", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '开票凭证'")
    private String billingDocument;
    @ApiModelProperty(value = "发票编号", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '发票编号'")
    private String billNumber;
    @ApiModelProperty(value = "发送方式", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '发送方式'")
    private String sendType;
    @ApiModelProperty(value = "接受邮箱", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '接受邮箱'")
    private String sendMail;
    @ApiModelProperty(value = "收件地址", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '收件地址'")
    private String sendAddress;
}