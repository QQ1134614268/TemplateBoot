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
import java.util.List;

@ApiModel(value = "用户")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "user")
@Entity(name = "user")
@org.hibernate.annotations.Table(appliesTo = "user", comment = "用户")
@Table(name = "user",
        indexes = {
                @Index(columnList = "userName", unique = true),
                @Index(columnList = "phone", unique = true),
                @Index(columnList = "email", unique = true),
                @Index(columnList = "petName")
        }
)
public class UserEntity extends BaseEntity {
    @Column(unique = false, nullable = true, columnDefinition = "varchar(64) COMMENT '用户名'")
    @ApiModelProperty(value = "用户名")
    private String userName;
    @Column(unique = false, nullable = true, columnDefinition = "varchar(32) COMMENT '手机号'")
    @ApiModelProperty(value = "手机号")
    private String phone;
    @Column(unique = false, nullable = true, columnDefinition = "varchar(32) COMMENT 'email'")
    @ApiModelProperty(value = "email")
    private String email;
    @Column(unique = false, nullable = true, columnDefinition = "varchar(64) COMMENT '昵称'")
    @ApiModelProperty(value = "昵称")
    private String petName;

    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '部门id'")
    @ApiModelProperty(value = "部门id",example = "1")
    private Long deptId;
    @Transient
    @TableField(exist = false)
    @ApiModelProperty(value = "用户地址")
    private String orgName;
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

