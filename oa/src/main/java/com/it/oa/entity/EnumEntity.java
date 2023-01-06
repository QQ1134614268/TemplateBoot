package com.it.oa.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.it.oa.config.TreeNode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@ApiModel(value = "分组设置")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "enum")
@Entity(name = "enum")
@Table(appliesTo = "enum", comment = "分组设置")
public class EnumEntity extends BaseEntity implements TreeNode<EnumEntity> {
    @ApiModelProperty(value = "唯一编码", example = "test_1", required = true)
    @Column(unique = true, nullable = false, columnDefinition = "varchar(64) COMMENT '唯一编码'")
    private String uniqueCode;
    @ApiModelProperty(value = "值", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '值'")
    private String value;
    @ApiModelProperty(value = "父级code", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(32) COMMENT '父级code'")
    private String parentCode;
    @ApiModelProperty(value = "父级id", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '父级id'")
    private Integer parentId;
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

    @Transient
    @TableField(exist = false)
    @ApiModelProperty(value = "子节点", example = "", required = false)
    private List<EnumEntity> children = new ArrayList<>();

    @Transient
    @TableField(exist = false)
    @ApiModelProperty(value = "路径ids", example = "", required = false)
    private List<Integer> parentIds = new ArrayList<>();
}