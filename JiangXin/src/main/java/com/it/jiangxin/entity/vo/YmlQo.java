package com.it.jiangxin.entity.vo;

import com.it.jiangxin.entity.YmlEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class YmlQo extends YmlEntity {

    @Schema(name = "level", example = "3")
    private Integer level = 3;
}
