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
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@ApiModel(value = "财务管理/账目记录/收支记账")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "finance_record")
@Entity(name = "finance_record")
@Table(appliesTo = "finance_record", comment = "财务管理/账目记录/收支记账")
public class FinanceRecordEntity extends BaseEntity {
    @ApiModelProperty(value = "账目分类id", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '账目分类id'")
    private Integer financeTypeId;
    @ApiModelProperty(value = "收支时间", example = "Tue Jul 05 12:35:58 CST 2022", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "datetime COMMENT '收支时间'")
    private Date payTime;
    @ApiModelProperty(value = "备注信息", example = "-522259151", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '备注信息'")
    private String note;
    @ApiModelProperty(value = "支付方式id", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '支付方式'")
    private Integer payTypeId;
    @ApiModelProperty(value = "账目金额", example = "0.1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "decimal(19,4) default 0 COMMENT '账目金额'")
    private BigDecimal financeMoney;

    @Transient
    @TableField(exist = false)
    @ApiModelProperty(value = "客户分类ids", example = "1", required = false)
    private List<Integer> financeTypeIds;
    // @ApiModelProperty(value = "账目类型", example = "1", required = false)
    // @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '账目类型'")
    // private Integer financeTypeIds;
}