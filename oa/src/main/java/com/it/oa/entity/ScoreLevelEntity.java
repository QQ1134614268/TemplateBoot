package com.it.oa.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;

@ApiModel(value = "人事管理/绩效考核/考核设置/考核评分")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "score_level")
@Entity(name = "score_level")
@Table(appliesTo = "score_level", comment = "人事管理/绩效考核/考核设置/考核评分")
public class ScoreLevelEntity extends BaseEntity {


    @ApiModelProperty(value = "等级名称", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '等级名称'")
    private String levelName;
    @ApiModelProperty(value = "等级区间范围", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '等级区间范围'")
    private String scoreSection;
    @ApiModelProperty(value = "等级说明", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '等级说明'")
    private String levelDescription;
}