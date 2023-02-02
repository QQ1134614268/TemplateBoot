package com.it.ac.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;


@ApiModel(value = "情指中心-布控管理-布控(人员,船舶)")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = XcCommandEntity.tableName, autoResultMap = true, excludeProperty = {"chargePersonDeptId", "feedback"})
public class XcCommandEntity extends BaseTableEntity {
    public final static String tableName = "xc_command";

    @ApiModelProperty(value = "任务名称", example = "", required = false)
    @Column(comment = "任务名称")
    private Integer taskName;

    @ApiModelProperty("任务地点-经度")
    @Column(comment = "任务地点-经度")
    private Double longitude;

    @ApiModelProperty("任务地点-纬度")
    @Column(comment = "任务地点-纬度")
    private Double latitude;

    @ApiModelProperty(value = "跟踪目标(MMSI,雷达编号)", example = "", required = false)
    @Column(comment = "跟踪目标(MMSI,雷达编号)")
    private String targetId;

    @ApiModelProperty("任务地点-纬度")
    @Column(comment = "任务地点-纬度")
    private Integer type;

    @ApiModelProperty(value = "任务描述", example = "", required = false)
    @Column(comment = "任务描述")
    private Integer taskDesc;

    @ApiModelProperty(value = "责任人", example = "", required = false)
    @Column(comment = "责任人")
    private Long chargePersonId;

    @TableField(exist = false)
    @ApiModelProperty(value = "责任人部门id", example = "", required = false)
    private Long chargePersonDeptId;

    @ApiModelProperty(value = "关联案件id", example = "", required = false)
    @Column(comment = "关联案件id")
    private Long relationCaseId;

    @ApiModelProperty(value = "任务状态(1:待分配;2:进行中;3:已完成)", example = "", required = false)
    @Column(comment = "任务状态(1:待分配;2:进行中;3:已完成)")
    private Integer taskStateId;

    @ApiModelProperty(value = "任务反馈", example = "", required = false)
    @TableField(exist = false)
    private List<String> feedback;
}

