package com.it.oa.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;

@ApiModel(value = "客户管理/客户列表/客户标签")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "customer_tag")
@Entity(name = "customer_tag")
@Table(appliesTo = "customer_tag", comment = "客户管理/客户列表/客户标签")
public class CustomerTagEntity extends BaseEntity {
    @ApiModelProperty(value = "客户Id", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '客户Id'")
    private Integer customerId;
    @ApiModelProperty(value = "标签id", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '标签id'")
    private Integer tagId;
}