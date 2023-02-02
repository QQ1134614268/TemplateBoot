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

@ApiModel(value = "人事管理/员工档案/教育经历")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "educational_experience")
@Entity(name = "educational_experience")
@Table(appliesTo = "educational_experience", comment = "人事管理/员工档案/教育经历")
public class EducationalExperienceEntity extends BaseEntity {

    @ApiModelProperty(value = "用户id", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '用户id'")
    private Integer userId;

    @ApiModelProperty(value = "入学时间", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "date COMMENT '入学时间'")
    private LocalDate admissionDate;
    @ApiModelProperty(value = "毕业时间", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "date COMMENT '毕业时间'")
    private LocalDate graduationDate;
    @ApiModelProperty(value = "学校名称", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '学校名称'")
    private String schoolName;
    @ApiModelProperty(value = "专业", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '专业'")
    private String major;
    @ApiModelProperty(value = "学位", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '学位'")
    private String education;
    @ApiModelProperty(value = "学历", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '学历'")
    private String academicDegree;
    @ApiModelProperty(value = "备注", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '备注'")
    private String note;
}