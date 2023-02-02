package com.it.oa.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@ApiModel(value = "行政管理/物资管理/消耗物资管理/物资记录")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "consume_goods_record")
@Entity(name = "consume_goods_record")
@Table(appliesTo = "consume_goods_record", comment = "行政管理/物资管理/消耗物资/物资记录")
public class ConsumeGoodsRecordEntity extends BaseEntity {
    @ApiModelProperty(value = "消耗物资id", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '消耗物资id'")
    private Integer consumeGoodsId;

    @ApiModelProperty(value = "领用人或组织Id", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '领用人或组织'")
    private Integer lendId;
    @ApiModelProperty(value = "领用人或组织", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '领用人或组织'")
    private String lendName;
    @ApiModelProperty(value = "业务类型", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '业务类型'")
    private String businessType;
    @ApiModelProperty(value = "变动数量", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) default 0 COMMENT '变动数量'")
    private Integer changeNum;
    @ApiModelProperty(value = "领用时间", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "datetime COMMENT '领用时间'")
    private LocalDateTime lendTime;

    @ApiModelProperty(value = "重要信息", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '领用时间'")
    private String majorInfo;
    @ApiModelProperty(value = "备注", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '备注'")
    private String note;
}