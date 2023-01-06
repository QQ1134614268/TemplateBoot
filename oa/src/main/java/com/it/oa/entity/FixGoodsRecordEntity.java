package com.it.oa.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;

@ApiModel(value = "行政管理/物资管理/消耗物资管理/物资记录")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "fix_goods_record")
@Entity(name = "fix_goods_record")
@Table(appliesTo = "fix_goods_record", comment = "行政管理/物资管理/消耗物资/物资记录")
public class FixGoodsRecordEntity extends BaseEntity {
    @ApiModelProperty(value = "领用人或组织Id", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '领用人或组织'")
    private Integer lendId;
    @ApiModelProperty(value = "领用人或组织", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '领用人或组织'")
    private String lendName;
    @ApiModelProperty(value = "业务类型", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '业务类型'")
    private String businessType;
    @ApiModelProperty(value = "固定物资id", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '固定物资id'")
    private Integer fixGoodsId;
    @ApiModelProperty(value = "重要信息", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '领用时间'")
    private String majorInfo;
    @ApiModelProperty(value = "备注", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '备注'")
    private String note;
    @ApiModelProperty(value = "变动数量", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) DEFAULT 1 COMMENT '领用人或组织'")
    private Integer changeNum;

    @ApiModelProperty(value = "维修金额", example = "1.0", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "float(12,4) default 0 COMMENT '维修金额'")
    private Float repairMoney;
}