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

@ApiModel(value = "客户管理/合同管理/续费记录")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "renew")
@Entity(name = "renew")
@Table(appliesTo = "renew", comment = "客户管理/合同管理/续费记录")
public class RenewEntity extends BaseEntity {

    @ApiModelProperty(value = "合同id", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '合同id'")
    private Integer contractId;
    @ApiModelProperty(value = "续费时间", example = "Tue Jul 05 12:35:58 CST 2022", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "datetime COMMENT '续费时间'")
    private Date payDate;
    @ApiModelProperty(value = "续费金额", example = "0.1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "decimal(19,4) default 0 COMMENT '续费金额'")
    private BigDecimal payMoney;
    @ApiModelProperty(value = "续费类型id", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '续费类型id'")
    private Integer typeId;
    @Transient
    @TableField(exist = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '续费类型'")
    private String type;
    @ApiModelProperty(value = "备注", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '备注'")
    private String note;
    @ApiModelProperty(value = "审核状态", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '审核状态'")
    private String status;
}