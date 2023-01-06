package com.it.boot.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.it.boot.config.tree.TreeNode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@ApiModel(value = "系统枚举")
@Data
@TableName(value = "sys_enum")
@Entity(name = "sys_enum")
@Table(appliesTo = "sys_enum", comment = "系统枚举")
public class SysEnumEntity  implements TreeNode{
    @Id
    @ApiModelProperty(value = "唯一编码", example = "test_1", required = true)
    @Column(unique = true, nullable = false, columnDefinition = "varchar(64) COMMENT '唯一编码'")
    private String code;
    @ApiModelProperty(value = "值", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '值'")
    private String value;
    @ApiModelProperty(value = "父级code", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(32) COMMENT '父级code'")
    private String parentCode;
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
    private List<SysEnumEntity> children = new ArrayList<>();

    @Override
    public String getParentId() {
        return parentCode;
    }

    @Override
    public String getId() {
        return code;
    }
}