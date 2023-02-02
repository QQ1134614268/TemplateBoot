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

@ApiModel(value = "人事管理/办公审批/审批记录")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "flow_record")
@Entity(name = "flow_record")
@Table(appliesTo = "flow_record", comment = "人事管理/办公审批/审批记录")
public class FlowRecordEntity extends BaseEntity {
    @ApiModelProperty(value = "审批流程id", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '审批流程id'")
    private Integer flowId;

    @ApiModelProperty(value = "申请人id", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '申请人id'")
    private Integer approvalUserId;

    @ApiModelProperty(value = "表单json", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "text COMMENT '表单json'")
    private String formJson;

    @Transient
    @TableField(exist = false)
    @ApiModelProperty(value = "表单项内容list", example = "test_1", required = false)
    private List<FormItemContentEntity> formItemContentList;

    @Transient
    @TableField(exist = false)
    @ApiModelProperty(value = "审批人", example = "[]", required = false)
    private List<FlowPersonEntity> flowPersonList = new ArrayList<>();
}