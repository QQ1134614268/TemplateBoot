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
import java.util.Date;

@ApiModel(value = "个人办公/我的日程")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "memo")
@Entity(name = "memo")
@Table(appliesTo = "memo", comment = "个人办公/我的日程")
public class MemoEntity extends BaseEntity {
    @ApiModelProperty(value = "业务类型", example = "test_1", required = true)
    @Column(unique = false, nullable = false, columnDefinition = "varchar(255) COMMENT '业务类型'")
    private String type;
    @ApiModelProperty(value = "内容", example = "test_1", required = true)
    @Column(unique = false, nullable = false, columnDefinition = "varchar(255) COMMENT '待办内容'")
    private String content;
    @ApiModelProperty(value = "备注", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(500) COMMENT '备注内容'")
    private String note;
    @ApiModelProperty(value = "提醒时间", example = "Tue Jul 05 12:35:58 CST 2022", required = true)
    @Column(unique = false, nullable = false, columnDefinition = "datetime COMMENT '提醒时间'")
    private Date remindTime;
    @ApiModelProperty(value = "重复提醒", example = "Tue Jul 05 12:35:58 CST 2022", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "datetime COMMENT '重复提醒'")
    private Date repeatRemindTime;
    @ApiModelProperty(value = "是否完成", example = "1436736902", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "bit(1) default 0 COMMENT '是否完成'")
    private Boolean isCompleted;


    @ApiModelProperty(value = "合同Id", example = "1436736902", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '合同Id'")
    private Integer contractId;

    @Transient
    @TableField(exist = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '合同Id'")
    private String contractName;

    @ApiModelProperty(value = "续费类型id", example = "1436736902", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '续费类型id'")
    private String repayTypeId;
    @Transient
    @TableField(exist = false)
    @ApiModelProperty(value = "续费类型", example = "1436736902", required = false)
    private String repayType;

    @ApiModelProperty(value = "付款提醒类型(回款提醒|续费提醒)", example = "1436736902", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '付款提醒类型(回款提醒|续费提醒)'")
    private String payType;

    @ApiModelProperty(value = "续费周期", example = "1436736902", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '续费类型'")
    private String repayCycle;
    @ApiModelProperty(value = "续费周期单位", example = "1436736902", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) default 0 COMMENT '续费周期单位'")
    private String unit;
    @ApiModelProperty(value = "续费金额", example = "1436736902", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "float(12,4) default 0 COMMENT '续费金额'")
    private Float money;
}