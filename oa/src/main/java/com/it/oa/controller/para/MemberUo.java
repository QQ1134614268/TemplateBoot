package com.it.oa.controller.para;

import com.it.oa.entity.UserEntity;
import com.it.oa.entity.UserOrgEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class MemberUo extends UserEntity {

    @ApiModelProperty(value = "员工id", example = "test_1", required = true)
    private Integer id;

    @ApiModelProperty(value = "员工姓名", example = "test_1", required = true)
    private String staffName;
    @ApiModelProperty(value = "手机号码", example = "test_1", required = false)
    private String phone;
    @ApiModelProperty(value = "性别", example = "test_1", required = false)
    private String sex;

    @ApiModelProperty(value = "部门ids", example = "test_1", required = false)
    private List<UserOrgEntity> orgIds;
    @ApiModelProperty(value = "组织id", example = "test_1", required = false)
    private Integer orgId;
    @ApiModelProperty(value = "是否是组织负责人", example = "test_1", required = false)
    private Boolean isOrgLeader;
    @ApiModelProperty(value = "职位", example = "test_1", required = false)
    private Integer postId;
    @ApiModelProperty(value = "直属上级", example = "test_1", required = false)
    private Integer directLeaderId;
    @ApiModelProperty(value = "管理范围", example = "test_1", required = false)
    private List<Integer> manageOrgIds;
}
