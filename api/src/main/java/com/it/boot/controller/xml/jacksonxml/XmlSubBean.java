package com.it.boot.controller.xml.jacksonxml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

@Data
public class XmlSubBean {

    @JacksonXmlProperty(localName = "sub_id")
    private Integer subId;

    @JacksonXmlProperty(localName = "sub_name")
    private String subName;

    @JacksonXmlProperty(localName = "sub_nick_name")
    private String subNickName;

}
