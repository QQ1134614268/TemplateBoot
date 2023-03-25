package com.it.sim.xml.jacksonxml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
public class UserXml {

    @JacksonXmlProperty(localName = "id")
    private Integer id;

    private String username;
    @JacksonXmlProperty(namespace = "namespace_username1")
    private String username1;
    @JacksonXmlProperty(localName = "localName_username2")
    private String username2;
    @JacksonXmlProperty(namespace = "namespace_username3", localName = "localName_username3")
    private String username3;

    @JacksonXmlElementWrapper(namespace = "namespace_username4" )//localName = "localName_Wrapper_teacher"
    @JacksonXmlProperty(localName = "localName_username4")
    private String username4;

    @JacksonXmlElementWrapper(namespace = "localName_username5" )//localName = "localName_Wrapper_teacher"
    @JacksonXmlProperty(localName = "localName_username5")
    private String username5;

    @JacksonXmlProperty(localName = "password", isAttribute = true)
    private String password;


    @JacksonXmlProperty(localName = "localName_userInfoXml")
    UserInfoXml userInfoXml;

    @JacksonXmlProperty(namespace = "namespace_userInfoXmlDto3", localName = "localName_userInfoXmlDto3")
    UserInfoXml userInfoXml3;

    @JacksonXmlElementWrapper(namespace = "namespace_Wrapper_userAddressXmlList",localName = "localName_Wrapper_userAddressXmlList") //localName = "localName_Wrapper_teacher",
    @JacksonXmlProperty(namespace = "namespace_addressXmlDtoList",localName = "localName_userAddressXmlList")//localName = "localName_teacher"
    List<UserAddressXml> userAddressXmlList;

}