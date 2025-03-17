package com.it.jpa.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "dept_jpa_t")
public class DeptEntity extends BaseEntity {
    @Column(columnDefinition = "varchar(255) COMMENT '部门名称'")
    private String name;
}