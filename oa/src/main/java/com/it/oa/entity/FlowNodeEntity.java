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
import java.util.List;

@ApiModel(value = "人事管理/办公审批/审批设置/流程节点")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "flow_node")
@Entity(name = "flow_node")
@Table(appliesTo = "flow_node", comment = "人事管理/办公审批/审批设置/流程节点")
public class FlowNodeEntity extends BaseEntity {

    @ApiModelProperty(value = "审批流程id", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '审批流程id'")
    private Integer flowId;

    @ApiModelProperty(value = "item唯一编码", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(64) COMMENT 'item唯一编码'")
    private String flowUniCode;

    @ApiModelProperty(value = "审批流父节点id程id", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '父节点id'")
    private Integer parentId;

    // 条件list | 审批人 | 抄送人
    @ApiModelProperty(value = "类型", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(32) COMMENT '类型'")
    private String type;

    // 审批人|抄送人选择条件(字段,计算得出来)
    @ApiModelProperty(value = "审批人|抄送人选择条件", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '审批人|抄送人选择条件'")
    private String selectUserCondition;

    // 审批人|抄送人
    @ApiModelProperty(value = "审批人|抄送人选择条件", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '审批人|抄送人选择条件'")
    private String userIds;

    @ApiModelProperty(value = "排序", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '排序'")
    private Integer sort;

    @Transient
    @TableField(exist = false)
    @ApiModelProperty(value = "子节点", example = "test_1", required = false)
    private List<FlowNodeEntity> children;

    @Transient
    @TableField(exist = false)
    @ApiModelProperty(value = "条件列表", example = "test_1", required = false)
    private List<FlowConditionEntity> flowConditionList;
}