package com.it.druid.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import lombok.Data;

@Data
@TableName(value = "user_batis_t") // MyBatis-Plus 注解，指定表名
@Table(name = "user_batis_t")  // Actable 注解，指定表名
public class UserEntity {
    @TableId(type = IdType.AUTO)
    @Column(isKey = true, isAutoIncrement = true, comment = "主键id")
    private Long id;
    @Column
    private String username;
}