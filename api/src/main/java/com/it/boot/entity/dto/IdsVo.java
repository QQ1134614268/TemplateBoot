package com.it.boot.entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @date 2022-10-22 18:41
 */
@Schema
@Data
public class IdsVo {
    @Schema(name = "对象id集合", example = "[1,2]")
    private List<Long> ids;
}
