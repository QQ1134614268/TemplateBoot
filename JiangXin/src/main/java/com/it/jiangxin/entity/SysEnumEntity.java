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
@TableName(value = "sys_enum")
@Entity(name = "sys_enum")
@Table(appliesTo = "sys_enum", comment = "系统枚举")
@Schema(name = "系统枚举表")
public class SysEnumEntity extends BaseEntity implements TreeNode {
    // 省市县, 下拉菜单, 下拉级联菜单
    @Schema(name = "分组code", example = "test_1")
    @Column(columnDefinition = "varchar(32) COMMENT '分组code'")
    private String groupCode; // 标识下拉

    @Schema(name = "父级id", example = "1")
    @Column(columnDefinition = "varchar(255) COMMENT '父级id'")
    private Integer parentId; // 标识级联

    @Schema(name = "唯一编码", example = "test_1", requiredMode = Schema.RequiredMode.REQUIRED)
    @Column(columnDefinition = "varchar(64) COMMENT '唯一编码'")
    private String uniCode;//  value 的唯一值, 表级唯一

    @Schema(name = "枚举的类别", example = "是|否")
    @Column(columnDefinition = "varchar(255) COMMENT '枚举的类别'")
    private String name;// 枚举的类别, 男女, 是否

    @Schema(name = "类别的代表", example = "1|0")
    @Column(columnDefinition = "varchar(255) COMMENT '类别的代表'")
    private String value; // 类别的代表, 比如 是:1, 否:0; 用户创建就没有代表,使用id进行关联??

    @Schema(name = "相同groupCode下排序", example = "1")
    @Column(columnDefinition = "int(11) COMMENT '相同groupCode下排序'")
    private Integer sort;

    @Schema(name = "备注", example = "备注")
    @Column(columnDefinition = "varchar(255) COMMENT '备注'")
    private String note;

    @Schema(name = "状态", example = "状态")
    @Column(columnDefinition = "varchar(255) COMMENT '状态'")
    private String status;

    @Transient
    @TableField(exist = false)
    @Schema(name = "子节点")
    private List<SysEnumEntity> children = new ArrayList<>();
}