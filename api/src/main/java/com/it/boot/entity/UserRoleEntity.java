package com.it.boot.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@ApiModel(value = "用户角色关系")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "user_role")
@Entity(name = "user_role")
@org.hibernate.annotations.Table(appliesTo = "user_role", comment = "用户角色关系")
@Table(name = "user_role",
        indexes = {
                @Index(columnList = "userId,roleId", unique = true),
        }
)
public class UserRoleEntity extends BaseEntity {
    private Integer userId;
    private Integer roleId;
}

