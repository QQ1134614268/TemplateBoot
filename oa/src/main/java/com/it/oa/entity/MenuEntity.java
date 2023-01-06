package com.it.oa.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;

@ApiModel(value = "系统管理/系统设置/菜单管理")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "menu")
@Entity(name = "menu")
@Table(appliesTo = "menu", comment = "系统管理/系统设置/菜单管理")
public class MenuEntity extends BaseEntity {
    @ApiModelProperty(value = "菜单名称", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '菜单名称'")
    private String menuName;
    @ApiModelProperty(value = "父级菜单id", example = "671964697", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '父级菜单id'")
    private Integer parentId;
    @ApiModelProperty(value = "是否选中", example = "-3521781", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "bit(1) COMMENT '是否选中'")
    private Boolean isSelect;
    @ApiModelProperty(value = "顺序", example = "-1059915402", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '顺序'")
    private Integer menuOrder;
}