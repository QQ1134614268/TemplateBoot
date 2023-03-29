package com.it.sim.json.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode
public class BaseVO implements Serializable {

    private Boolean isDelete;

}
