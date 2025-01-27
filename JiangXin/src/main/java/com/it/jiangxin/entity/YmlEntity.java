package com.it.jiangxin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

import java.util.List;

import static com.it.jiangxin.entity.YmlEntity.tableName;
import static com.it.jiangxin.entity.YmlEntity.tableNameDesc;

@Schema(name = tableNameDesc)
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = tableName)
@Entity(name = tableName)
@Table(appliesTo = tableName, comment = tableNameDesc)
public class YmlEntity extends BaseEntity {

    public static final String tableName = "tree_yml_t";
    public static final String tableNameDesc = "yml内容";

    @Schema(name = "父级id", example = "test_1")
    @Column(columnDefinition = "int DEFAULT 0 COMMENT '父级id'")
    private Integer parentId;

    @Schema(name = "问题", example = "test_1")
    @Column(unique = true, columnDefinition = "text COMMENT '问题'")
    private String ask;

    @Schema(name = "yml内容", example = "test_1")
    @Column(nullable = false, columnDefinition = "text COMMENT 'yml内容'")
    private String value;

    @Schema(name = "权重", example = "0.1")
    @Column(columnDefinition = "float COMMENT '权重'")
    private Float weight;

    @Schema(name = "标签", example = "test_1")
    @Column(columnDefinition = "text COMMENT '标签'")
    private String tag;

    @Schema(name = "案例", example = "test_1")
    @Column(columnDefinition = "text COMMENT '案例'")
    private String demo;

    @Schema(name = "基础数据", example = "test_1")
    @Column(columnDefinition = "JSON COMMENT '基础数据'")
    private String db;

    @Schema(name = "验证过程", example = "test_1")
    @Column(columnDefinition = "JSON COMMENT '验证过程'")
    private String prove;

    @Transient
    @TableField(exist = false)
    @Schema(name = "验证过程", example = "test_1")
    private List<YmlEntity> children;

}
