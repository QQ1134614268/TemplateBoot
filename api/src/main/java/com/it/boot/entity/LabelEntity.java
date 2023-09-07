package com.it.boot.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@ApiModel(value = "标签")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "label")
@Entity(name = "label")
@org.hibernate.annotations.Table(appliesTo = "label", comment = "权限")
@Table(name = "label",
        indexes = {
                @Index(columnList = "name", unique = true),
        }
)
public class LabelEntity extends BaseEntity { // todo
    @Column(unique = false, nullable = false, columnDefinition = "varchar(64) COMMENT '权限名称'")
    @ApiModelProperty(value = "权限名称")
    private String name;
}
