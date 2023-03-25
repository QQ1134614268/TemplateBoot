package com.it.sim.xml.jacksonxml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

@Data
public class UserInfoXml {
    @JacksonXmlProperty(localName = "id")
    private Integer id;
    @JacksonXmlProperty(localName = "age")
    private Integer age;
    @JacksonXmlProperty(localName = "sex")
    private Boolean sex;
}