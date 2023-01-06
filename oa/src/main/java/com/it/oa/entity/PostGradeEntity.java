package com.it.oa.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;

@ApiModel(value = "人事管理/职位管理/职位管理/职等")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "post2")
@Entity(name = "post2")
@Table(appliesTo = "post2", comment = "人事管理/职位管理/职位管理/职等")
public class PostGradeEntity extends BaseEntity {
    @ApiModelProperty(value = "职等最小值", example = "1", required = true)
    @Column(unique = false, nullable = false, columnDefinition = "varchar(255) COMMENT '职等最小值'")
    private Float postGradeMin;
    @ApiModelProperty(value = "职等最大值", example = "1.0", required = true)
    @Column(unique = false, nullable = false, columnDefinition = "varchar(255) COMMENT '职等最大值'")
    private Float postGradeMax;
    @ApiModelProperty(value = "薪资最小值", example = "1.0", required = true)
    @Column(unique = false, nullable = false, columnDefinition = "varchar(255) COMMENT '薪资最小值'")
    private Float salaryMin;
    @ApiModelProperty(value = "薪资最大值", example = "1.0", required = true)
    @Column(unique = false, nullable = false, columnDefinition = "varchar(255) COMMENT '薪资最大值'")
    private Float salaryMax;

}