package com.it.sim.xml.jacksonxml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

@Data
@JacksonXmlRootElement(namespace = "UserAddressXml", localName = "localName_UserAddressXml")
public class UserAddressXml {
    @JacksonXmlProperty(localName = "id")
    private Integer id;

    @JacksonXmlProperty(localName = "address")
    private String address;

}