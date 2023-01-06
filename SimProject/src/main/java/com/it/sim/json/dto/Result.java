package com.it.sim.json.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @date 2022-11-16 11:48
 */
//一个泛型类
@Data
@EqualsAndHashCode
public class Result<T> {

    private String code;
    private T data;
}

