package com.it.oa.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel(value = "客户管理/合同管理/付款提醒")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "pay_warn")
@Entity(name = "pay_warn")
@Table(appliesTo = "pay_warn", comment = "客户管理/合同管理/付款提醒")
public class PayWarnEntity extends BaseEntity {
    @ApiModelProperty(value = "付款提醒时间", example = "Tue Jul 05 12:35:58 CST 2022", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "datetime COMMENT '付款提醒时间'")
    private Date warnDate;
    @ApiModelProperty(value = "回款金额", example = "0.1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "decimal(19,4) default 0 COMMENT '回款金额'")
    private BigDecimal payMoney;
    @ApiModelProperty(value = "备注", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '备注'")
    private String note;
}