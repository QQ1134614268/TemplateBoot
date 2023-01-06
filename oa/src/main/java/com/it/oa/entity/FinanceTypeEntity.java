package com.it.oa.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
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

@ApiModel(value = "财务管理/账目设置/账目分类")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "finance_type")
@Entity(name = "finance_type")
@Table(appliesTo = "finance_type", comment = "财务管理/账目设置/账目分类")
public class FinanceTypeEntity extends BaseEntity {//implements TreeNode<FinanceTypeEntity>
    @ApiModelProperty(value = "账目类型", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '账目类型'")
    private String category;
    @ApiModelProperty(value = "账目分类", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '账目分类'")
    private String type;
    @ApiModelProperty(value = "父级id", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '父级id'")
    private Integer parentId;
    @ApiModelProperty(value = "层级", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '层级'")
    private Integer level;

    @Transient
    @TableField(exist = false)
    @ApiModelProperty(value = "路径ids", example = "", required = false)
    private List<Integer> parentIds = new ArrayList<>();
    // @Transient
    // @TableField(exist = false)
    // @ApiModelProperty(value = "子节点", example = "", required = false)
    // private List<FinanceTypeEntity> children = new ArrayList<>();
}