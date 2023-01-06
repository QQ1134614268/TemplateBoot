package com.it.sim.webservice.cxf.service;

import javax.jws.WebService;

@WebService(endpointInterface = "com.it.sim.webservice.cxf.service.IHelloService")
public class HelloServiceImpl implements IHelloService{
    @Override
    public String sayX(String name) {
        return name+"say hi";
    }
}
