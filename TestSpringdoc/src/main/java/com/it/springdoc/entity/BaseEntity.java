package com.it.springdoc.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
public class BaseEntity implements Serializable {
    @Schema(defaultValue = "id")
    private Long id;
}

