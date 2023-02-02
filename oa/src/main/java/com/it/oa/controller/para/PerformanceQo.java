package com.it.oa.controller.para;

import com.it.oa.controller.para.BasePara;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;

@Data
public class PerformanceQo extends BasePara {

    @ApiModelProperty(value = "绩效考核周期", example = "test_1", required = false)
    private String cycle;
    @ApiModelProperty(value = "待办事项", example = "", required = false)
    private String undo;
    @ApiModelProperty(value = "被考核人id", example = "-1440003502", required = false)
    private Integer userId;

    @ApiModelProperty(value = "考核状态", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '考核状态'")
    private String status;

}
