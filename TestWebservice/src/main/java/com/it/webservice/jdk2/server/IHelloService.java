package com.it.webservice.jdk2.server;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@SuppressWarnings("HttpUrlsUsage")
@WebService(
        targetNamespace = "http://it.com"
)
@SOAPBinding(style = SOAPBinding.Style.RPC) // rpc: wsdl中少了一些类型
public interface IHelloService {
    @WebMethod // 只要有一个WebMethod, 类中所有方法都会默认添加
    @WebResult(name = "ret")
    String sayHi(@WebParam(name = "name") String name);

    @WebMethod(operationName = "sayHello")
    String sayHi1(String name);
}
