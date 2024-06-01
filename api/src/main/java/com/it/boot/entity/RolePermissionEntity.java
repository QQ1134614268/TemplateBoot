package com.it.boot.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Schema(name = "角色权限关系")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "role_permission")
@Entity(name = "role_permission")
@org.hibernate.annotations.Table(appliesTo = "role_permission", comment = "角色权限关系")
@Table(name = "role_permission",
        indexes = {
                @Index(columnList = "roleId,permissionId", unique = true),
        }
)
public class RolePermissionEntity extends BaseEntity {
    private Integer roleId;
    private Integer permissionId;
}

