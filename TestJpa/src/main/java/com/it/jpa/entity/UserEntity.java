package com.it.jpa.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "UserJpaTable")
@Table(name = "user_jpa_t", indexes = {
        @Index(columnList = "userName", unique = true),
        @Index(columnList = "phone", unique = true),
        @Index(columnList = "email", unique = true),
        @Index(columnList = "nickName")}
)
public class UserEntity extends BaseEntity {
    @Column(unique = true, nullable = false, columnDefinition = "varchar(255) COMMENT '用户名'")
    private String username;
    @Column(columnDefinition = "varchar(255) COMMENT '密码'")
    private String password;
    @Column(columnDefinition = "varchar(255) COMMENT '员工头像'")
    private String avatar;
    @Column(columnDefinition = "varchar(255) COMMENT '手机号码'")
    private String phone;
    @Column(unique = true, columnDefinition = "varchar(20) COMMENT '昵称'")
    private String nickName;
    @Column(columnDefinition = "varchar(255) COMMENT '邮箱'")
    private String email;
    @Column(columnDefinition = "datetime COMMENT '出生日期'")
    private Date birthDay;
    @Column(columnDefinition = "varchar(255) COMMENT '状态'")
    private String status;
    @Column(columnDefinition = "int(11) COMMENT '部门id'")
    private Long deptId;
    @Transient // jpa 忽略字段
    private String deptName;
    // @OneToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "deptId", referencedColumnName = "id", insertable = false, updatable = false)
    // private DeptEntity deptEntity; // jpa 连表使用
    // @Transient
    // private List<AddressEntity> addressList = new ArrayList<>();

}