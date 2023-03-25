package com.it.sim.xml.javaxml;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @date 2023-03-14 17:06
 * <p>
 * todo 优化,类比jacksonXml
 */
@Data
@XmlRootElement(name = "user")
// @XmlType(name = "User", namespace = "com.it.sim.xml.javaxml")
public class UserXml {

    // @XmlElement(name = "Id")
    private Integer id;

    // @XmlElement(name = "Username", required = true)
    private String username;

    // @XmlElement(name = "password")
    private String password;

    // @XmlAnyAttribute
    // private HashMap<String, Object> anyAttribute;

    // @XmlAnyElement
    // private HashMap<String, Object> anyElement;

    // private UserInfoXml userInfoXml;
    //
    // private List<UserAddrXml> userAddrXmlList;

}
