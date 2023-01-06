package com.it.oa.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel(value = "人事管理/办公审批/审批设置")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "form_item")
@Entity(name = "form_item")
@Table(appliesTo = "form_item", comment = "人事管理/办公审批/审批设置")
public class FormItemEntity extends BaseEntity {
    @ApiModelProperty(value = "审批流程id", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '审批流程id'")
    private Integer flowId;
    @ApiModelProperty(value = "位置顺序", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(32) COMMENT '位置顺序'")
    private String sort;
    @ApiModelProperty(value = "是否必填", example = "true", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "bit(1) COMMENT '是否必填'")
    private Boolean isRequired;
    @ApiModelProperty(value = "数据类型", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(32) COMMENT '数据类型'")
    private String type;
    @ApiModelProperty(value = "单行文本数据", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(32) COMMENT '单行文本数据'")
    private String singleText;
    @ApiModelProperty(value = "多行文本数据", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(32) COMMENT '多行文本数据'")
    private String multiText;
    // 数字, 整数,小数, 最大,最小
    @ApiModelProperty(value = "数字值", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(32) COMMENT '数字值'")
    private String num;
    @ApiModelProperty(value = "最大值", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(32) COMMENT '最大值'")
    private String numMax;
    @ApiModelProperty(value = "最小值", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(32) COMMENT '最小值'")
    private String numMin;
    @ApiModelProperty(value = "金额", example = "0.1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "decimal(19,4) default 0 COMMENT '金额'")
    private BigDecimal money;
    @ApiModelProperty(value = "单位", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(32) COMMENT '单位'")
    private String moneyUnit;
    @ApiModelProperty(value = "日期", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(32) COMMENT '日期'")
    private String date;
    @ApiModelProperty(value = "最小日期", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(32) COMMENT '最小日期'")
    private String dateMin;
    @ApiModelProperty(value = "最大日期", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(32) COMMENT '最大日期'")
    private String dateMax;
    // 时间
    @ApiModelProperty(value = "时间", example = "Tue Jul 05 12:35:58 CST 2022", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "datetime COMMENT '时间'")
    private Date datetime;
    @ApiModelProperty(value = "最大时间", example = "Tue Jul 05 12:35:58 CST 2022", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "datetime COMMENT '最大时间'")
    private Date datetimeMax;
    @ApiModelProperty(value = "最小时间", example = "Tue Jul 05 12:35:58 CST 2022", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "datetime COMMENT '最小时间'")
    private Date datetimeMin;
    // 区间日期
    @ApiModelProperty(value = "区间日期", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(32) COMMENT '区间日期'")
    private String dateSection;
    @ApiModelProperty(value = "区间日期开始", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(32) COMMENT '区间日期开始'")
    private String dateSectionBegin;
    @ApiModelProperty(value = "区间日期结束", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(32) COMMENT '区间日期结束'")
    private String dateSectionEnd;
    // 区间时间
    @ApiModelProperty(value = "区间时间", example = "Tue Jul 05 12:35:58 CST 2022", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "datetime COMMENT '区间时间'")
    private Date timeSection;
    @ApiModelProperty(value = "区间开始时间", example = "Tue Jul 05 12:35:58 CST 2022", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "datetime COMMENT '区间开始时间'")
    private Date timeSectionBegin;
    @ApiModelProperty(value = "区间结束时间", example = "Tue Jul 05 12:35:58 CST 2022", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "datetime COMMENT '区间结束时间'")
    private Date timeSectionEnd;
    // 单选|多选|选择器
    @ApiModelProperty(value = "枚举值", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(32) COMMENT '枚举值'")
    private String checkItems;
    // 成员
    @ApiModelProperty(value = "审批人", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(32) COMMENT '审批人'")
    private String memberItems;
    // 部门
    @ApiModelProperty(value = "部门", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(32) COMMENT '部门'")
    private String orgItems;
    // 附件
    @ApiModelProperty(value = "附件", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(32) COMMENT '附件'")
    private String fileItems;
    // 明细
    @ApiModelProperty(value = "明细", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(32) COMMENT '明细'")
    private String info;
    // 文字
    @ApiModelProperty(value = "文字", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(32) COMMENT '文字'")
    private String text;
}