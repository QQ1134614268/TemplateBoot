package com.it.jiangxin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.it.jiangxin.config.TreeNode;
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
@TableName(value = "img")
@Entity(name = "img")
@Table(appliesTo = "img", comment = "图片")
public class ImgEntity extends BaseEntity implements TreeNode {

    @ApiModelProperty(value = "首页名", example = "test_1", required = true)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(64) COMMENT '首页名'")
    private String name;

    @ApiModelProperty(value = "图片地址", example = "test_1", required = true)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(128) COMMENT '图片地址'")
    private String imgUrl;

    @ApiModelProperty(value = "描述", example = "test_1", required = true)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(64) COMMENT '描述'")
    private String description;

    @ApiModelProperty(value = "父级id", example = "0", required = true)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '父级id'")//DEFAULT 0
    private Integer parentId;

    @ApiModelProperty(value = "分类id", example = "1", required = true)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '分类id'")
    private Integer typeId;

    @Transient
    @TableField(exist = false)
    @ApiModelProperty(value = "分类名称", example = "test_1", required = true)
    private String typeName;

    @Transient
    @TableField(exist = false)
    @ApiModelProperty(value = "子节点", example = "test_1", required = true)
    private List<ImgEntity> children = new ArrayList<>();
}
