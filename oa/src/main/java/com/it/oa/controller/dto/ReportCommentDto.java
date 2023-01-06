package com.it.oa.controller.dto;


import com.it.oa.entity.ReportCommentEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ReportCommentDto extends ReportCommentEntity {

    @ApiModelProperty(value = "员工姓名", example = "test_1", required = false)
    private String staffName;
    @ApiModelProperty(value = "员工头像", example = "test_1", required = false)
    private String avatar;

}