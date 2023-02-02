package com.it.oa.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;

@ApiModel(value = "人事管理/员工档案/任职经历")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "post_experience")
@Entity(name = "post_experience")
@Table(appliesTo = "post_experience", comment = "人事管理/员工档案/任职经历")
public class PostExperienceEntity extends BaseEntity {
    @ApiModelProperty(value = "员工id", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '员工id'")
    private Integer userId;
    @ApiModelProperty(value = "开始时间", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "date COMMENT '开始时间'")
    private LocalDate startDate;
    @ApiModelProperty(value = "结束时间", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "date COMMENT '结束时间'")
    private LocalDate endDate;
    @ApiModelProperty(value = "职位", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255)COMMENT '职位'")
    private String post;
    @ApiModelProperty(value = "部门", example = "部门", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '部门id'")
    private String orgName;
    @ApiModelProperty(value = "身份", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255)COMMENT '身份'")
    private String identity;
    @ApiModelProperty(value = "任职状态", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255)COMMENT '任职状态'")
    private String postStatus;
    @ApiModelProperty(value = "备注", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255)COMMENT '备注'")
    private String note;
}