package com.it.boot.entity;

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
import java.util.Date;
import java.util.List;

@ApiModel(value = "部门")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "dept")
@Entity(name = "dept")
@Table(appliesTo = "dept", comment = "部门")
public class DeptEntity extends BaseEntity {
    @ApiModelProperty(value = "部门名称", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '部门名称'")
    private String name;
}