package com.it.druid.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "user_batis_t") // MyBatis-Plus 注解，指定表名
public class UserEntity {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String username;
}