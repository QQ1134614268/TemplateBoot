package com.it.oa.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;

@ApiModel(value = "个人办公/办公中心/汇报")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "report")
@Entity(name = "report")
@Table(appliesTo = "report", comment = "个人办公/办公中心/汇报")
public class ReportEntity extends BaseEntity {
    @ApiModelProperty(value = "员工id", example = "1053892493", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '员工id'")
    private Integer userId;
    @ApiModelProperty(value = "汇报类型", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '汇报类型'")
    private String type;
    @ApiModelProperty(value = "今日工作内容", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '今日工作内容'")
    private String content;
    @ApiModelProperty(value = "明日计划", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '明日计划'")
    private String plan;
    @ApiModelProperty(value = "备注", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '备注'")
    private String note;
    @ApiModelProperty(value = "上级评价", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '上级评价'")
    private String leaderAppraise;
}