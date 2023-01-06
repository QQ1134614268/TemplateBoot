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

@ApiModel(value = "行政管理/企业动态/公告")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "announcement")
@Entity(name = "announcement")
@Table(appliesTo = "announcement", comment = "行政管理/企业动态/公告")
public class AnnouncementEntity extends BaseEntity {
    @ApiModelProperty(value = "公告标题", example = "test_1", required = true)
    @Column(unique = false, nullable = false, columnDefinition = "varchar(255) COMMENT '公告标题'")
    private String title;
    @ApiModelProperty(value = "公告分类id", example = "1", required = true)
    @Column(unique = false, nullable = false, columnDefinition = "int(11) COMMENT '公告分类id'")
    private Integer typeId;
    @Transient
    @TableField(exist = false)
    @ApiModelProperty(value = "类型名称", example = "test_1", required = true)
    private String typeName;
    @ApiModelProperty(value = "公告简介", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '公告简介'")
    private String description;
    @ApiModelProperty(value = "公告封面", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '公告封面'")
    private String img;
    @ApiModelProperty(value = "公告正文", example = "test_1", required = true)
    @Column(unique = false, nullable = false, columnDefinition = "varchar(255) COMMENT '公告正文'")
    private String content;
    @ApiModelProperty(value = "状态", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "bit(1) COMMENT '状态'")
    private Boolean isOpen;
    @ApiModelProperty(value = "已读人数", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) default 0 COMMENT '已读人数'")
    private Integer num;
    @Transient
    @TableField(exist = false)
    @ApiModelProperty(value = "创建人姓名", example = "test_1", required = false)
    private String staffName;
}