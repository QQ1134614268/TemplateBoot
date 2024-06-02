package com.it.jiangxin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.it.jiangxin.config.TreeNode;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@Schema(name = "分组设置")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "img")
@Entity(name = "img")
@Table(appliesTo = "img", comment = "图片")
public class ImgEntity extends BaseEntity implements TreeNode { // todo 优化数据结构 首页标识,label标签, name desc字段

    @Schema(name = "首页名", example = "test_1", required = true)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(64) COMMENT '首页名'")
    private String name;

    @Schema(name = "图片地址", example = "test_1", required = true)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(128) COMMENT '图片地址'")
    private String imgUrl;

    @Schema(name = "描述", example = "test_1", required = true)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(64) COMMENT '描述'")
    private String description;

    @Schema(name = "父级id", example = "0", required = true)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '父级id'")// DEFAULT 0
    private Integer parentId;

    @Schema(name = "分类id", example = "1", required = true)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '分类id'")
    private Integer typeId;

    @Transient
    @TableField(exist = false)
    @Schema(name = "分类名称", example = "test_1", required = true)
    private String typeName;

    @Transient
    @TableField(exist = false)
    @Schema(name = "子节点", example = "test_1", required = true)
    private List<ImgEntity> children = new ArrayList<>();
}
