package com.it.oa.controller.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;


@Data
public class UserRoleDto2 {
    @ApiModelProperty(value = "员工id", example = "1", required = false)
    private Integer id;
    @ApiModelProperty(value = "姓名", example = "-127623817", required = false)
    private String staffName;
    @ApiModelProperty(value = "部门", example = "-127623817", required = false)
    private String orgName;
    @ApiModelProperty(value = "电话", example = "-127623817", required = false)
    private String phone;
    @ApiModelProperty(value = "加入时间", example = "-127623817", required = false)
    private LocalDate entryDate;
    @ApiModelProperty(value = "职位", example = "-413844420", required = false)
    private String postName;
}