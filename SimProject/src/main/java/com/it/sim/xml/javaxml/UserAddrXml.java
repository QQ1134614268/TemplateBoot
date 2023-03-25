package com.it.sim.xml.javaxml;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;

/**
 * @date 2023-03-14 17:10
 */
@Data
public class UserAddrXml {

    @XmlElement(name = "Address", required = true)
    private String address;
}
