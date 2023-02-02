package com.it.sim.webservice.cxf.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.5.4
 * 2022-11-03T23:16:26.401+08:00
 * Generated source version: 3.5.4
 *
 */
@SuppressWarnings("ALL")
@WebService(targetNamespace = "http://service.cxf.webservice.sim.it.com/", name = "IHelloService")
@XmlSeeAlso({ObjectFactory.class})
public interface IHelloService {

    @WebMethod
    @RequestWrapper(localName = "sayX", targetNamespace = "http://service.cxf.webservice.sim.it.com/", className = "com.it.sim.webservice.cxf.client.SayX")
    @ResponseWrapper(localName = "sayXResponse", targetNamespace = "http://service.cxf.webservice.sim.it.com/", className = "com.it.sim.webservice.cxf.client.SayXResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.lang.String sayX(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );
}
