package com.it.boot.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Schema(name = "用户")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "user")
@Entity(name = "user")
@org.hibernate.annotations.Table(appliesTo = "user", comment = "用户")
@Table(name = "user", indexes = {
                @Index(columnList = "userName", unique = true),
                @Index(columnList = "phone", unique = true),
                @Index(columnList = "email", unique = true),
                @Index(columnList = "nickName")}
)
public class UserEntity extends BaseEntity {
    @Schema(name = "用户名", example = "test_1", required = true)
    @Column(unique = true, nullable = false, columnDefinition = "varchar(255) COMMENT '用户名'")
    private String userName;
    @Schema(name = "密码", example = "test_1")
    @Column(columnDefinition = "varchar(255) COMMENT '密码'")
    private String password;
    @Schema(name = "员工头像", example = "test_1")
    @Column(columnDefinition = "varchar(255) COMMENT '员工头像'")
    private String avatar;
    @Schema(name = "手机号码", example = "test_1")
    @Column(columnDefinition = "varchar(255) COMMENT '手机号码'")
    private String phone;
    @Schema(name = "昵称", example = "test_1", required = true)
    @Column(unique = true, columnDefinition = "varchar(20) COMMENT '昵称'")
    private String nickName;
    @Schema(name = "邮箱", example = "test_1")
    @Column(columnDefinition = "varchar(255) COMMENT '邮箱'")
    private String email;
    @Schema(name = "出生日期", example = "2020-10-10 00:00:00")
    @Column(columnDefinition = "datetime COMMENT '出生日期'")
    private Date birthDay;
    @Schema(name = "状态", example = "test_1")
    @Column(columnDefinition = "varchar(255) COMMENT '状态'")
    private String status;
    @Column(columnDefinition = "int(11) COMMENT '部门id'")
    @Schema(name = "部门id", example = "1")
    private Long deptId;
    @Transient // jpa 忽略字段
    @TableField(exist = false) // mybatis 忽略字段
    @Schema(name = "部门名称")
    private String deptName;
    @TableField(exist = false)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deptId", referencedColumnName = "id", insertable = false, updatable = false)
    private DeptEntity deptEntity; // jpa 连表使用
    @Transient
    @TableField(exist = false)
    @Schema(name = "用户地址")
    private List<AddressEntity> addressList = new ArrayList<>();

}