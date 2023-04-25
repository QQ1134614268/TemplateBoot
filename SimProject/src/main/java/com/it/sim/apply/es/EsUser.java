package com.it.sim.apply.es;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.it.sim.config.TimeConf;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EsUser {
    private String id;

    private String name;

    @JsonFormat(pattern = TimeConf.YYYY_MM_DD)
    private Date birthday;

    private String desc;

    private String address;

    private Float height;
}
