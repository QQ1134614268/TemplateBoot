package com.it.sim.json.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

//一个普通类
@Data
@EqualsAndHashCode
public class Book {

    private Integer id;
    private String name;
}

