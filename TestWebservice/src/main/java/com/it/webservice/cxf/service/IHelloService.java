package com.it.webservice.cxf.service;

import javax.jws.WebService;

@WebService
public interface IHelloService {
    String sayX(String name);
}
