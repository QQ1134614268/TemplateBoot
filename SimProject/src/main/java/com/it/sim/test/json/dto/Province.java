package com.it.sim.test.json.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @date 2022-11-16 10:51
 */
@Data
@EqualsAndHashCode
public class Province {

    Integer id;

    String provinceName;

    List<City> cityList;
}
