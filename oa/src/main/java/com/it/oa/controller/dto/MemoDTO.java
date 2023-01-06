package com.it.oa.controller.dto;

import com.it.oa.entity.MemoEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ApiModel
@Data
public class MemoDTO {
    @ApiModelProperty(value = "日期")
    private LocalDate date;
    @ApiModelProperty(value = "是否有待办")
    private Boolean hasData;
    @ApiModelProperty(value = "是否有未完成的待办")
    private Boolean hasUndo;
    @ApiModelProperty(value = "待办")
    private List<MemoEntity> children = new ArrayList<>();
}
