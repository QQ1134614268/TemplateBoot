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

@ApiModel(value = "人事管理/绩效考核/考核设置/考核指标")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "performance_index")
@Entity(name = "performance_index")
@Table(appliesTo = "performance_index", comment = "人事管理/绩效考核/考核设置/考核指标")
public class PerformanceIndexEntity extends BaseEntity {
    @ApiModelProperty(value = "绩效考核id", example = "-1559360188", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '绩效考核id'")
    private Integer performanceId;
    @ApiModelProperty(value = "绩效指标", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '绩效指标'")
    private String target;
    @ApiModelProperty(value = "绩效指标详情", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '绩效指标详情'")
    private String targetDescription;
    @ApiModelProperty(value = "自我评价(完成情况)", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '自我评价(完成情况)'")
    private String selfAppraise;
    @ApiModelProperty(value = "自我评分", example = "0.1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "float(12,4) default 0 COMMENT '自我评分'")
    private Float selfScore;
    @ApiModelProperty(value = "上级评价", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '上级评价'")
    private String leaderAppraise;
    @ApiModelProperty(value = "上级评分", example = "0.1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "float(12,4) default 0 COMMENT '上级评分'")
    private Float leaderScore;

    @ApiModelProperty(value = "父级id", example = "-1559360188", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '父级id'")
    private Integer parentId;


    @Transient
    @TableField(exist = false)
    @ApiModelProperty(value = "子节点", example = "", required = false)
    private List<PerformanceIndexEntity> children;
}