package com.it.boot.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.it.boot.config.tree.TreeNodeV1;
import io.swagger.v3.oas.annotations.media.Schema;
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
public class SysEnumEntity extends BaseEntity implements TreeNodeV1<Long> { //  implements TreeNode

    @Schema(name = "分组code", example = "test_1")
    @Column(columnDefinition = "varchar(32) COMMENT '分组code'")
    private String groupCode;

    @Schema(name = "编码", example = "test_1", required = true)
    @Column(columnDefinition = "varchar(64) COMMENT '编码'")
    private String uniCode;

    @Schema(name = "值", example = "test_1")
    @Column(columnDefinition = "varchar(255) COMMENT '值'")
    private String value;

    @Schema(name = "值", example = "test_1")
    @Column(columnDefinition = "varchar(255) COMMENT '翻译标签'")
    private String label;

    @Schema(name = "备注", example = "test_1")
    @Column(columnDefinition = "varchar(255) COMMENT '备注'")
    private String note;

    @Schema(name = "相同groupCode下排序", example = "535233937")
    @Column(columnDefinition = "int(11) COMMENT '相同groupCode下排序'")
    private Integer sort;

    @Schema(name = "状态", example = "test_1")
    @Column(columnDefinition = "varchar(255) COMMENT '状态'")
    private String status;

    @Schema(name = "父级id", example = "1")
    @Column(columnDefinition = "varchar(255) COMMENT '父级id'")
    private Long parentId;

    @Transient
    @TableField(exist = false)
    @Schema(name = "子节点")
    private List<SysEnumEntity> children = new ArrayList<>();

}