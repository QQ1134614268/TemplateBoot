package com.it.jpa.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@MappedSuperclass // jpa 本类字段被继承
public class BaseEntity implements Serializable {
    @Id //
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // JPA主键生成策略,自增
    @Column(columnDefinition = "int(11) COMMENT '主键'") // Jpa 表字段定义
    private Long id;

    @Column(columnDefinition = "datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'")
    private Date createTime;

    @Column(columnDefinition = "datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'")
    private Date updateTime;

    @Column(columnDefinition = "int(11) COMMENT '创建者id'")
    private Long createBy;

    @Column(columnDefinition = "int(11) COMMENT '修改者id'")
    private Long updateBy;

}

