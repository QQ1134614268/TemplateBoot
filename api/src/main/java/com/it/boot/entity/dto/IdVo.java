package com.it.boot.entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @date 2022-10-22 18:41
 */
@Schema
@Data
public class IdVo {
    @Schema(title = "对象id", example = "1")
    private Integer id;
}
