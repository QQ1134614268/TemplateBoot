package com.it.boot.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;

@ApiModel(value = "测试缓存")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "cache")
@Entity(name = "cache")
@Table(appliesTo = "cache", comment = "测试缓存")
public class CacheEntity extends BaseEntity {
    @Column(columnDefinition = "varchar(255) COMMENT 'value'")
    @ApiModelProperty(value = "value", example = "123")
    private String value;
}