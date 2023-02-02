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
import java.util.ArrayList;
import java.util.List;

@ApiModel(value = "行政管理/物资管理/消耗物资管理")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "consume_goods")
@Entity(name = "consume_goods")
@Table(appliesTo = "consume_goods", comment = "行政管理/物资管理/消耗物资")
public class ConsumeGoodsEntity extends BaseEntity {
    @ApiModelProperty(value = "物资名称", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '物资名称'")
    private String goodsName;
    @ApiModelProperty(value = "物资分类id", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '物资分类id'")
    private Integer typeId;
    @ApiModelProperty(value = "物资型号", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(20) COMMENT '物资型号'")
    private String model;
    @ApiModelProperty(value = "计量单位", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(64) COMMENT '计量单位'")
    private String unit;
    @ApiModelProperty(value = "生产厂家", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(64) COMMENT '生产厂家'")
    private String manufacturer;
    @ApiModelProperty(value = "备注", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(64) COMMENT '备注'")
    private String note;

    @ApiModelProperty(value = "库存数量", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) default 0 COMMENT '库存数量'")
    private Integer reserveNum;
    @ApiModelProperty(value = "单价", example = "1.0", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "float(12,4) default 0 COMMENT '单价'")
    private Float unitPrice;
    @ApiModelProperty(value = "入库说明", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '入库说明'")
    private String putNote;

    @ApiModelProperty(value = "领用数量", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) default 0 COMMENT '领用数量'")
    private Integer lendNum;

    @Transient
    @TableField(exist = false)
    @ApiModelProperty(value = "物资分类路径id", example = "1", required = false)
    private List<Integer> typeIds = new ArrayList<>();
}