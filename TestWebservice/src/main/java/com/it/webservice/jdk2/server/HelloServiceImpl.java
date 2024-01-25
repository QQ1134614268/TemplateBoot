package com.it.webservice.jdk2.server;


import javax.jws.WebService;

/**
 * @date 2022-10-24 09:38
 */
@SuppressWarnings("HttpUrlsUsage")
@WebService(
        targetNamespace = "http://it.com", // 接口同步修改, 限定名
        serviceName = "helloService", // 服务名
        portName = "helloServicePort",// 端口名
        endpointInterface = "com.it.sim.webservice.jdk2.server.IHelloService"
)
public class HelloServiceImpl implements IHelloService {

    @Override
    public String sayHi(String name) {
        return name + "say HI";
    }

    @Override
    public String sayHi1(String name) {
        return null;
    }
}
