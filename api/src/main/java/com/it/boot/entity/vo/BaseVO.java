package com.it.boot.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseVO implements Serializable {
    @Schema(name = "id", example = "1")
    private Integer id;
    @Schema(name = "id", example = "2000-01-01 00:00:00")
    private Date createTime;
}
