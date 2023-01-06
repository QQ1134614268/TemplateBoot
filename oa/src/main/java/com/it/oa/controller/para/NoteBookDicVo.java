package com.it.oa.controller.para;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class NoteBookDicVo {
    @ApiModelProperty(value = "对象id", example = "1", required = false)
    private Integer id;
    @ApiModelProperty(value = "父级文件夹id", example = "1", required = false)
    private Integer parentId;
    @ApiModelProperty(value = "文件夹名", example = "72260227", required = false)
    private String fileName;
    @ApiModelProperty(value = "文件夹层级", example = "72260227", required = false)
    private Integer level;
    @ApiModelProperty(value = "记事本个数", example = "72260227", required = false)
    private Long noteNum;
    private List<NoteBookDicVo> children = new ArrayList<>();
}
