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

@ApiModel(value = "人事管理/办公审批/审批设置/表单内容")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "form_item_content")
@Entity(name = "form_item_content")
@Table(appliesTo = "form_item_content", comment = "人事管理/办公审批/审批设置/表单内容")
public class FormItemContentEntity extends BaseEntity {

    @ApiModelProperty(value = "表单项code", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(64) COMMENT '表单项code'")
    String formItemUniCode;
    @ApiModelProperty(value = "取值", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '取值'")
    String value;
    @ApiModelProperty(value = "开始时间", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '开始时间'")
    LocalDateTime startTime;
    @ApiModelProperty(value = "结束时间", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '结束时间'")
    LocalDateTime endTime;

}
