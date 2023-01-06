package com.it.oa.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;

@ApiModel(value = "人事管理/办公审批/审批设置/审批人")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "flow_person")
@Entity(name = "flow_person")
@Table(appliesTo = "flow_person", comment = "人事管理/办公审批/审批设置/审批人")
public class FlowPersonEntity extends BaseEntity {
    @ApiModelProperty(value = "类型(审批人|抄送人)", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(32) COMMENT '类型(审批人|抄送人)'")
    private String type;
    @ApiModelProperty(value = "审批人|抄送人选择条件", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(32) COMMENT '审批人|抄送人选择条件'")
    private String userIds;
}
