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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ApiModel(value = "个人办公/办公中心/绩效考核")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "performance")
@Entity(name = "performance")
@Table(appliesTo = "performance", comment = "个人办公/办公中心/绩效考核")
public class PerformanceEntity extends BaseEntity {
    @ApiModelProperty(value = "被考核人id", example = "-1440003502", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '员工id'")
    private Integer userId;
    @Transient
    @TableField(exist = false)
    @ApiModelProperty(value = "被考核人姓名", example = "-1440003502", required = false)
    private String staffName;

    @ApiModelProperty(value = "考核人id", example = "-1440003502", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '员工id'")
    private Integer leaderId;
    @Transient
    @TableField(exist = false)
    @ApiModelProperty(value = "考核人姓名", example = "-1440003502", required = false)
    private String leaderName;

    @ApiModelProperty(value = "绩效考核名称", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '绩效考核名称'")
    private String assessmentName;
    @ApiModelProperty(value = "绩效考核周期", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '绩效考核周期'")
    private String cycle;
    @ApiModelProperty(value = "绩效考核开始时间", example = "Tue Jul 05 12:35:58 CST 2022", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "date COMMENT '绩效考核开始时间'")
    private LocalDate startTime;
    @ApiModelProperty(value = "绩效考核结束时间", example = "Tue Jul 05 12:35:58 CST 2022", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "date COMMENT '绩效考核结束时间'")
    private LocalDate endTime;
    @ApiModelProperty(value = "考核得分", example = "0.1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "float(12,4) default 0 COMMENT '考核得分'")
    private Float score;
    @ApiModelProperty(value = "考核等级id", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '考核等级id'")
    private Integer levelId;
    @Transient
    @TableField(exist = false)
    @ApiModelProperty(value = "考核等级", example = "-1440003502", required = false)
    private String levelName;

    @ApiModelProperty(value = "考核状态", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '考核状态'")
    private String status;

    @ApiModelProperty(value = "开启状态状态", example = "true", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "bit(1) COMMENT '开启状态状态'")
    private Boolean isOpen;

    @Transient
    @TableField(exist = false)
    @ApiModelProperty(value = "子节点", example = "[]", required = false)
    private List<PerformanceIndexEntity> list = new ArrayList<>();

    @ApiModelProperty(value = "是否删除", example = "true", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "bit(1) COMMENT '是否删除'")
    private Boolean isDelete;
    @ApiModelProperty(value = "删除原因", example = "true", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '删除原因'")
    private String deleteReason;
}