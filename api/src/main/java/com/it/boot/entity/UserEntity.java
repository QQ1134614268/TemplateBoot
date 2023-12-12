package com.it.boot.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ApiModel(value = "用户")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "user")
@Entity(name = "user")
@org.hibernate.annotations.Table(appliesTo = "user", comment = "用户")
@Table(name = "user", indexes = {@Index(columnList = "userName", unique = true), @Index(columnList = "phone", unique = true), @Index(columnList = "email", unique = true), @Index(columnList = "nickName")})
public class UserEntity extends BaseEntity {
    @ApiModelProperty(value = "用户名", example = "test_1", required = true)
    @Column(unique = true, nullable = false, columnDefinition = "varchar(255) COMMENT '用户名'")
    private String userName;
    @ApiModelProperty(value = "密码", example = "test_1")
    @Column(columnDefinition = "varchar(255) COMMENT '密码'")
    private String password;
    @ApiModelProperty(value = "员工头像", example = "test_1")
    @Column(columnDefinition = "varchar(255) COMMENT '员工头像'")
    private String avatar;
    @ApiModelProperty(value = "手机号码", example = "test_1")
    @Column(columnDefinition = "varchar(255) COMMENT '手机号码'")
    private String phone;
    @ApiModelProperty(value = "昵称", example = "test_1", required = true)
    @Column(unique = true, columnDefinition = "varchar(20) COMMENT '昵称'")
    private String nickName;
    @ApiModelProperty(value = "邮箱", example = "test_1")
    @Column(columnDefinition = "varchar(255) COMMENT '邮箱'")
    private String email;
    @ApiModelProperty(value = "出生日期", example = "2020-10-10 00:00:00")
    @Column(columnDefinition = "datetime COMMENT '出生日期'")
    private Date birthDay;
    @ApiModelProperty(value = "状态", example = "test_1")
    @Column(columnDefinition = "varchar(255) COMMENT '状态'")
    private String status;
    @Column(columnDefinition = "int(11) COMMENT '部门id'")
    @ApiModelProperty(value = "部门id", example = "1")
    private Long deptId;
    @Transient
    @TableField(exist = false)
    @ApiModelProperty(value = "部门名称")
    private String deptName;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deptId", referencedColumnName = "id", insertable = false, updatable = false)
    private DeptEntity deptEntity; // jpa 连表使用
    @Transient
    @TableField(exist = false)
    @ApiModelProperty(value = "用户地址")
    private List<AddressEntity> addressList = new ArrayList<>();

    /**
     * 删除标记 0-未删除 1-已删除
     */
    @ApiModelProperty(value = "逻辑删除标记(0:未删除; 1:已删除)")
    @TableLogic(value = "0", delval = "1")
    private Integer delFlag;
}