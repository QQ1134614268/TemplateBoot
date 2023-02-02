package com.it.oa.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;

@ApiModel(value = "客户管理/客户列表/附件相关")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "customer_file")
@Entity(name = "customer_file")
@Table(appliesTo = "customer_file", comment = "客户管理/客户列表/附件相关")
public class CustomerFileEntity extends BaseEntity {
    @ApiModelProperty(value = "客户id", example = "858540281", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '跟进客户id'")
    private Integer customerId;
    @ApiModelProperty(value = "附件地址", example = "497768827", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '附件地址'")
    private String filePath;
    @ApiModelProperty(value = "文件名", example = "497768827", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '附件地址'")
    private String fileName;
}