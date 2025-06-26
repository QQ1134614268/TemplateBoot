package com.it.boot.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.UniqueConstraint;


@Schema(title = "用户部门关系")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "user_dept_relation")
@Entity(name = "user_dept_relation")
@org.hibernate.annotations.Table(appliesTo = "user_dept_relation", comment = "用户部门关系")
@javax.persistence.Table(name = "user_dept_relation", uniqueConstraints = @UniqueConstraint(columnNames = {"userId", "deptId"}))
public class UserDeptEntity extends BaseEntity {
    private Integer userId;
    private Integer deptId;
}

