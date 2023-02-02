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
import java.util.Date;

@ApiModel(value = "客户管理/合同管理/付款记录")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "pay_record")
@Entity(name = "pay_record")
@Table(appliesTo = "pay_record", comment = "客户管理/合同管理/付款记录")
public class PayRecordEntity extends BaseEntity {
    @ApiModelProperty(value = "合同id", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '合同id'")
    private Integer contractId;
    @Transient
    @TableField(exist = false)
    @ApiModelProperty(value = "合同名称", example = "test_1", required = false)
    private String contractName;
    @ApiModelProperty(value = "回款时间", example = "Tue Jul 05 12:35:58 CST 2022", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "datetime COMMENT '回款时间'")
    private Date payDate;
    @ApiModelProperty(value = "回款金额", example = "0.1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "decimal(19,4) default 0 COMMENT '回款金额'")
    private BigDecimal payMoney;
    @ApiModelProperty(value = "备注", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '备注'")
    private String note;
    @ApiModelProperty(value = "审核状态", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '审核状态'")
    private String checkStatus;
    @ApiModelProperty(value = "业务类型", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '业务类型'")
    private String type;
    @ApiModelProperty(value = "业务内容", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '业务内容'")
    private String content;
}