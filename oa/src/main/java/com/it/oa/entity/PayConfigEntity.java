package com.it.oa.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;

@ApiModel(value = "财务管理/财务设置/支付方式")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "pay_config")
@Entity(name = "pay_config")
@Table(appliesTo = "pay_config", comment = "财务管理/财务设置/支付方式")
public class PayConfigEntity extends BaseEntity {
    @ApiModelProperty(value = "支付方式key", example = "WECHAT_PAY", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(20) COMMENT '支付方式英文(key)'")
    private String payNameEn;
    @ApiModelProperty(value = "支付方式", example = "微信支付", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(20) COMMENT '支付方式'")
    private String payNameCn;
    @ApiModelProperty(value = "是否支持", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "bit(1) COMMENT '是否支持'")
    private Boolean isOpen;
}