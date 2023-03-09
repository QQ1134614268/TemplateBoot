package com.it.boot.controller.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

@JacksonXmlRootElement(localName = "document")
@Data
public class CreditLoanApproveAckNotifyDto {
    // @JacksonXmlElementWrapper(localName ="request")
    // private Request request;
    @JacksonXmlProperty(localName = "signature")
    private String signature;

    // @Data
    // public class Request {
    //     @JacksonXmlElementWrapper(localName ="head")
    //     private Header head;
    //     @JacksonXmlElementWrapper(localName ="body")
    //     private NotifyDomain body;
    // }
}
