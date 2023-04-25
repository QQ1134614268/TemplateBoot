package com.it.sim.test.json.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * JSON序列化和反序列化使用的User类
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Country extends BaseVO {

    private Integer id;

    private String name;

    private Integer age;

    private Date birthday;

    private LocalDate localDate;

    private LocalDateTime localDateTime;

    private List<Province> provinceList = new ArrayList<>();

}
