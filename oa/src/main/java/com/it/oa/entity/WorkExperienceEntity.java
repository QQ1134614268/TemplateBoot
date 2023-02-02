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

@ApiModel(value = "人事管理/员工档案/工作经历")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "work_experience")
@Entity(name = "work_experience")
@Table(appliesTo = "work_experience", comment = "人事管理/员工档案/工作经历")
public class WorkExperienceEntity extends BaseEntity {

    @ApiModelProperty(value = "员工id", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '员工id'")
    private Integer userId;

    @ApiModelProperty(value = "开始时间", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "date COMMENT '开始时间'")
    private LocalDate startDate;

    @ApiModelProperty(value = "结束时间", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "date COMMENT '结束时间'")
    private LocalDate endDate;

    @ApiModelProperty(value = "公司名", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '公司名'")
    private String companyName;

    @ApiModelProperty(value = "工作描述", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '工作描述'")
    private String workDesc;
    @ApiModelProperty(value = "职位", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '职位'")
    private String post;
    @ApiModelProperty(value = "离职原因", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '离职原因'")
    private String leaveReason;
}