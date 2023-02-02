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

@ApiModel(value = "人事管理/绩效考核/绩效设置/考核计划/考核人员")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "performance_plan_user")
@Entity(name = "performance_plan_user")
@Table(appliesTo = "performance_plan_user", comment = "人事管理/绩效考核/绩效设置/考核计划/考核人员")
public class PerformancePlanUserEntity extends BaseEntity {
    @ApiModelProperty(value = "考核计划Id", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '考核计划Id'")
    private Integer performancePlanId;
    @ApiModelProperty(value = "用户id", example = "721361978", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '用户id'")
    private Integer userId;
    @Transient
    @TableField(exist = false)
    @ApiModelProperty(value = "用户名称", example = "721361978", required = false)
    private String staffName;
}