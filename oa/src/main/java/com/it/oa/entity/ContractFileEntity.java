package com.it.oa.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;

@ApiModel(value = "客户管理/合同管理/附件相关")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "contract_file")
@Entity(name = "contract_file")
@Table(appliesTo = "contract_file", comment = "客户管理/合同管理/附件相关")
public class ContractFileEntity extends BaseEntity {
    @ApiModelProperty(value = "客户id", example = "858540281", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '跟进客户id'")
    private Integer contractId;
    @ApiModelProperty(value = "附件地址", example = "497768827", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '附件地址'")
    private String filePath;
    @ApiModelProperty(value = "文件名", example = "497768827", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '附件地址'")
    private String fileName;
}