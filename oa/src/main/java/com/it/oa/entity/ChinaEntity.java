package com.it.oa.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.it.oa.config.TreeNode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ApiModel(value = "中国省市区")
@Data
@TableName(value = "china")
@Entity(name = "china")
@Table(appliesTo = "china", comment = "中国省市区")
public class ChinaEntity implements TreeNode<ChinaEntity> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // 主键生成策略,自增
    @TableId(type = IdType.AUTO)
    @Column(columnDefinition = "int(11) COMMENT '主键'")
    @ApiModelProperty(value = "对象id", example = "1")
    private Integer id;

    @Column(unique = false, nullable = false, columnDefinition = "varchar(32) COMMENT '名称'")
    @ApiModelProperty(value = "名称", example = "北京市")
    private String name;
    @Column(columnDefinition = "int(11) COMMENT '父级id'")
    @ApiModelProperty(value = "父级id", example = "1")
    private Integer parentId;

    @Transient
    @TableField(exist = false)
    @ApiModelProperty(value = "子节点")
    private List<ChinaEntity> children = new ArrayList<>();
}
