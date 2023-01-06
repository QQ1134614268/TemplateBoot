package com.it.boot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.it.boot.config.tree.TreeNode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ApiModel(value = "分组设置")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "enum")
@Entity(name = "enum")
@Table(appliesTo = "enum", comment = "分组设置")
public class UserEnumEntity extends BaseEntity implements TreeNode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // 主键生成策略,自增
    @TableId(type = IdType.AUTO)
    @Column(columnDefinition = "int(11) COMMENT '主键'")
    @ApiModelProperty(value = "对象id", example = "1")
    private Long id; // todo 已经继承?

    @ApiModelProperty(value = "值", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '值'")
    private String value;
    @ApiModelProperty(value = "分组code", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(32) COMMENT '分组code'")
    private String groupCode;
    @ApiModelProperty(value = "相同groupCode下排序", example = "535233937", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '相同groupCode下排序'")
    private Integer sort;
    @ApiModelProperty(value = "备注", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '备注'")
    private String note;
    @ApiModelProperty(value = "状态", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '状态'")
    private String status;

    @ApiModelProperty(value = "父级id", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '父级id'")
    private Long parentId;

    @Transient
    @TableField(exist = false)
    @ApiModelProperty(value = "子节点", example = "", required = false)
    private List<UserEnumEntity> children = new ArrayList<>();
}