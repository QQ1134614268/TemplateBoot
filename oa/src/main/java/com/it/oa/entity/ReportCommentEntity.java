package com.it.oa.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;

@ApiModel(value = "个人办公/办公中心/汇报/评论")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "report_comment")
@Entity(name = "report_comment")
@Table(appliesTo = "report_comment", comment = "个人办公/办公中心/汇报/评论")
public class ReportCommentEntity extends BaseEntity {
    @ApiModelProperty(value = "汇报id", example = "1053892493", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '汇报id'")
    private Integer reportId;
    @ApiModelProperty(value = "评论", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '评论'")
    private String content;
    @ApiModelProperty(value = "评论人id", example = "1053892493", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '评论人id'")
    private Integer userId;
}