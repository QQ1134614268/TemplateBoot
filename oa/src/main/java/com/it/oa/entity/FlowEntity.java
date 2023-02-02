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
import java.util.ArrayList;
import java.util.List;

@ApiModel(value = "人事管理/办公审批/审批设置")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "flow")
@Entity(name = "flow")
@Table(appliesTo = "flow", comment = "人事管理/办公审批/审批设置")
public class FlowEntity extends BaseEntity {
    @ApiModelProperty(value = "审批类型", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(32) COMMENT '审批类型'")
    private String flowName;
    @ApiModelProperty(value = "审批图标", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(32) COMMENT '审批图标'")
    private String icon;
    @ApiModelProperty(value = "审批类型说明", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(32) COMMENT '审批图标'")
    private String description;

    @ApiModelProperty(value = "申请人", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(32) COMMENT '申请人'")
    private String applicantId;

    @ApiModelProperty(value = "审批人ids", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(32) COMMENT '审批人ids'")
    private String approvalIds;

    @ApiModelProperty(value = "抄送人", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(32) COMMENT '抄送人'")
    private String ccIds;

    @ApiModelProperty(value = "异常处理", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(32) COMMENT '异常处理'")
    private String errHandel;

    @ApiModelProperty(value = "异常处理转交人", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(32) COMMENT '异常处理转交人'")
    private String errHandelPerson;

    // 当同一个审批人重复审批同一单据时, 1. 首节点审批,其余自动同意 2. 仅连续审批时同意 3. 每个几点都要审批
    @ApiModelProperty(value = "自动审批", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(32) COMMENT '自动审批'")
    private String autoApproval;

    @ApiModelProperty(value = "修改权限", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(32) COMMENT '修改权限'")
    private String modifyPermission;

    @ApiModelProperty(value = "撤销权限", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(32) COMMENT '撤销权限'")
    private String cancelPermission;


    @ApiModelProperty(value = "状态", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(32) COMMENT '状态'")
    private String status;

    @Transient
    @TableField(exist = false)
    @ApiModelProperty(value = "表单列表", example = "test_1", required = false)
    private List<FormItemEntity> formItemList = new ArrayList<>();

    @Transient
    @TableField(exist = false)
    @ApiModelProperty(value = "流程节点", example = "test_1", required = false)
    private List<FlowNodeEntity> flowNodeTree = new ArrayList<>();
}