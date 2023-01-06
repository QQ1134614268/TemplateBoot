package com.it.boot.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@ApiModel(value = "用户")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "address")
@Entity(name = "address")
@org.hibernate.annotations.Table(appliesTo = "address", comment = "用户")
@Table(name = "address", indexes = {@Index(columnList = "userId")})
public class AddressEntity extends BaseEntity {
    private Integer userId;
    private String name;
    private String city;
    private String addressInfo;

    @Transient
    @TableField(exist = false)
    @ApiModelProperty(value = "用户名")
    private String userName;

    @Transient
    @TableField(exist = false)
    private UserEntity userEntity;
}

