package com.it.sim.xml.javaxml;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * @date 2023-03-14 17:06
 * <p>
 */
@Data
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD) // 属性映射成xml标签
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL) // 字段属性顺序
public class UserXml implements Serializable {

    private Integer id;

    @XmlElement(name = "userName")
    private String userName;

    @XmlAttribute(name = "password")
    private String password;


    @XmlTransient
    private String xmlTransient;

    private List<String> xmlList1;

    @XmlList
    private List<String> xmlList2;

    @XmlElementWrapper
    @XmlElement(name = "userAddrXmlList")
    // @XmlElements({@XmlElement(name = "UserAddrXml", type =UserAddrXml.class)}) // 接口与更具体的类
    private List<UserAddrXml> userAddrXmlList;


    @XmlElement(name = "userInfoXml")
    private UserInfoXml userInfoXml;

    // @XmlJavaTypeAdapter(UserInfoXmlConvert.class)
    // private UserInfoXml xml3;


    @XmlAnyAttribute
    private HashMap<String, Object> anyAttribute;

    @XmlAnyElement
    private HashMap<String, Object> anyElement;


}
