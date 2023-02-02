package com.it.oa.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;

@ApiModel(value = "客户管理/客户列表/跟进记录/附件")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "progress_file")
@Entity(name = "progress_file")
@Table(appliesTo = "progress_file", comment = "客户管理/客户列表/跟进记录/附件")
public class ProgressFileEntity extends BaseEntity {
    @ApiModelProperty(value = "跟进记录id", example = "858540281", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '跟进客户id'")
    private Integer progressId;
    @ApiModelProperty(value = "附件地址", example = "497768827", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '附件地址'")
    private String filePath;
    @ApiModelProperty(value = "文件名", example = "497768827", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '附件地址'")
    private String fileName;
}