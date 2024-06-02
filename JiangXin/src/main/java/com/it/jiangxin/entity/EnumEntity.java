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

@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "enum")
@Entity(name = "enum")
@Table(appliesTo = "enum", comment = "系统枚举")
@Schema(name = "系统枚举表")
public class EnumEntity extends BaseEntity implements TreeNode {

    @Schema(name = "值", example = "test_1")
    @Column(columnDefinition = "varchar(255) COMMENT '值'")
    private String value;

    @Schema(name = "值", example = "test_1")
    @Column(columnDefinition = "varchar(255) COMMENT '翻译标签'")
    private String label;

    @Schema(name = "唯一编码", example = "test_1", required = true)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(64) COMMENT '唯一编码'")
    private String uniCode;

    @Schema(name = "分组code", example = "test_1")
    @Column(columnDefinition = "varchar(32) COMMENT '分组code'")
    private String groupCode;

    @Schema(name = "相同groupCode下排序", example = "1")
    @Column(columnDefinition = "int(11) COMMENT '相同groupCode下排序'")
    private Integer sort;

    @Schema(name = "备注", example = "备注1")
    @Column(columnDefinition = "varchar(255) COMMENT '备注'")
    private String note;

    @Schema(name = "状态", example = "状态1")
    @Column(columnDefinition = "varchar(255) COMMENT '状态'")
    private String status;

    @Schema(name = "父级id", example = "1")
    @Column(columnDefinition = "varchar(255) COMMENT '父级id'")
    private Integer parentId;

    @Transient
    @TableField(exist = false)
    @Schema(name = "子节点")
    private List<EnumEntity> children = new ArrayList<>();

}