package com.it.oa.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;

@ApiModel(value = "人事管理/办公审批/审批设置/条件表达式")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "flow_condition")
@Entity(name = "flow_condition")
@Table(appliesTo = "flow_condition", comment = "人事管理/办公审批/审批设置/条件表达式")
public class FlowConditionEntity extends BaseEntity {
    @ApiModelProperty(value = "流程节点Id", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '流程节点Id'")
    private Integer flowNodeId;

    // 大于 等于 小于 包含
    @ApiModelProperty(value = "操作符(大于 等于 小于 包含)", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(64) COMMENT '(大于 等于 小于 包含)'")
    private String operation;

    @ApiModelProperty(value = "对比的值", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(64) COMMENT '对比的值'")
    private String value;

    @ApiModelProperty(value = "顺序", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(64) COMMENT '顺序'")
    private String sort;
    @ApiModelProperty(value = "名称", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(64) COMMENT '名称'")
    private String conditionName;
}