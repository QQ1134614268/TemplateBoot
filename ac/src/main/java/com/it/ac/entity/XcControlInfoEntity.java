package com.it.ac.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;


@ApiModel(value = "情指中心-布控管理-布控(人员,船舶)")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = XcControlInfoEntity.tableName, autoResultMap = true,excludeProperty = {"tableName","controlTypeName","alarmNum"})
public class XcControlInfoEntity extends BaseTableEntity {
    public final static String tableName = "xc_control_info";

    @Column(comment = "布控类型(1: 船舶布控, 2:人员布控)")
    @ApiModelProperty(value = "布控类型(1: 船舶布控, 2:人员布控)", example = "", required = false)
    private Integer controlCategory;

    @Column(comment = "布控名称")
    @ApiModelProperty(value = "布控名称", example = "", required = false)
    private String controlName;

    @Column(comment = "布控等级")
    @ApiModelProperty(value = "布控等级", example = "", required = false)
    private String controlLevel;


    // @ApiModelProperty(value = "审批id", example = "", required = false)
    // private Integer approveId;

    // @ApiModelProperty(value = "审批信息json", example = "", required = false)
    // @TableField(exist = false)
    // @Column(type = MySqlTypeConstant.JSON, comment = "审批信息json")
    // private ApprovalJson approvalJson;

    @Column(comment = "截止日期")
    @ApiModelProperty(value = "截止日期", example = "", required = false)
    private Date expiryDate;

    @Column(comment = "布控分类id")
    @ApiModelProperty(value = "布控分类id", example = "1", required = false)
    private Integer controlTypeId;

    @TableField(exist = false)
    @ApiModelProperty(value = "布控分类名称", example = "", required = false)
    private String controlTypeName;

    // @ApiModelProperty(value = "布控区域信息", example = "", required = false)
    // @TableField(typeHandler = JacksonTypeHandler.class)
    // @Column(type = MySqlTypeConstant.JSON, comment = "布控区域信息")
    // private List<ControlAreaJson> controlAreaJsonList;

    @TableField(exist = false)
    @ApiModelProperty(value = "公开方式(0: 所有人可见, 1: 本部门可见, 3: 本人可见)", example = "", required = false)
    @Column(comment = "公开方式(0: 所有人可见, 1: 本部门可见, 3: 本人可见")
    private Integer publicWay;

    @TableField(exist = false)
    @ApiModelProperty(value = "布控事由", example = "", required = false)
    @Column(comment = "布控事由")
    private String controlReason;

    @ApiModelProperty(value = "是否开启短信通知(0:不开通, 1: 开通)", example = "1", required = false)
    @Column(comment = "是否开启短信通知(0:不开通, 1: 开通)")
    private Integer isOpenSms;

    //1 布控内容
    @ApiModelProperty(value = "布控类型为 人员布控 时, 布控子类型(0: 手机布控,1: 人员布控, 2: 车辆布控)", example = "", required = false)
    @Column(comment = "布控类型为 人员布控 时, 布控子类型(0: 手机布控,1: 人员布控, 2: 车辆布控)")
    private Integer controlSubTypeId;

    // // 1.1 船舶布控
    // @ApiModelProperty(value = "船舶布控", example = "", required = false)
    // @TableField(typeHandler = JacksonTypeHandler.class)
    // @Column(type = MySqlTypeConstant.JSON, comment = "船舶布控")
    // private ShipConditionJson shipConditionJson;
    //
    // // 1.2 人员布控
    // @ApiModelProperty(value = "人员布控", example = "", required = false)
    // @TableField(typeHandler = JacksonTypeHandler.class)
    // @Column(type = MySqlTypeConstant.JSON, comment = "人员布控")
    // private PersonCtrlJson personCtrlJson;

    @Column(comment = "布控状态;(0:待审批,1:已布控,2:已撤控) ")
    @ApiModelProperty(value = "布控状态;(0:待审批,1:已布控,2:已撤控) ", example = "1", required = false)
    private Integer controlStatus;

    @TableField(exist = false)
    @ApiModelProperty(value = "预警次数", example = "1", required = false)
    private Integer alarmNum;
}
