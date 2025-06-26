package com.it.boot.entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @date 2023-03-27 16:25
 */
@Schema
@Data
public class AddressDtoJson {

    @Schema(title = "名称", example = "1")
    private String name;

    @Schema(title = "省市县名", example = "1")
    private List<String> names;
}
