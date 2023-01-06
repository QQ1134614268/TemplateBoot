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

@ApiModel(value = "客户管理/合同管理")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "contract")
@Entity(name = "contract")
@Table(appliesTo = "contract", comment = "客户管理/合同管理")
public class ContractEntity extends BaseEntity {
    @ApiModelProperty(value = "合同名称", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '合同名称'")
    private String contractName;
    @ApiModelProperty(value = "客户名称id", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '客户名称id'")
    private Integer customerId;
    @Transient
    @TableField(exist = false)
    @ApiModelProperty(value = "客户名称", example = "客户名称1", required = false)
    private String customerName;
    @ApiModelProperty(value = "合同金额", example = "0.1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "decimal(19,4) default 0 COMMENT '合同金额'")
    private BigDecimal contractMoney;
    @ApiModelProperty(value = "开始时间", example = "Tue Jul 05 12:35:58 CST 2022", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "datetime COMMENT '开始时间'")
    private LocalDate startTime;
    @ApiModelProperty(value = "结束时间", example = "Tue Jul 05 12:35:58 CST 2022", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "datetime COMMENT '结束时间'")
    private LocalDate endTime;
    @ApiModelProperty(value = "备注", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '备注'")
    private String note;
    @ApiModelProperty(value = "负责人id", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '负责人id'")
    private Integer chargePersonId;
    @ApiModelProperty(value = "是否关注", example = "-797690037", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "bit(1) COMMENT '是否关注'")
    private Boolean isFollow;
    @Transient
    @TableField(exist = false)
    @ApiModelProperty(value = "负责人", example = "test_1", required = false)
    private String chargePerson;
}