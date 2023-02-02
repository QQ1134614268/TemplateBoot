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

@ApiModel(value = "人事管理/绩效考核/绩效设置/考核计划")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "performance_plan")
@Entity(name = "performance_plan")
@Table(appliesTo = "performance_plan", comment = "人事管理/绩效考核/绩效设置/考核计划")
public class PerformancePlanEntity extends BaseEntity {
    @ApiModelProperty(value = "绩效类型", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '绩效类型'")
    private String type;
    @ApiModelProperty(value = "是否开启", example = "721361978", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "bit(1) COMMENT '是否开启'")
    private Boolean isOpen;

    @Transient
    @TableField(exist = false)
    @ApiModelProperty(value = "考核人员", example = "1,2", required = false)
    private List<PerformancePlanUserEntity> planUsers;

    // @Transient
    // @TableField(exist = false)
    // @ApiModelProperty(value = "考核人员", example = "1,2", required = false)
    // private List<UserDTO> users;
    // @Transient
    // @TableField(exist = false)
    // @ApiModelProperty(value = "考核人员", example = "1,2", required = false)
    // private List<UserEntity> users;
}