package com.it.boot.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;

@Schema(title = "部门")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "dept")
@Entity(name = "dept")
@Table(appliesTo = "dept", comment = "部门")
public class DeptEntity extends BaseEntity {
    @Schema(title = "部门名称", example = "test_1")
    @Column(columnDefinition = "varchar(255) COMMENT '部门名称'")
    private String name;
}