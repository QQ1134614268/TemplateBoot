package com.it.sim.xml.javaxml;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;

/**
 * @date 2023-03-14 17:10
 */
@Data
public class UserInfoXml {
    @XmlElement(name = "Age", required = true)
    private String age;
}
