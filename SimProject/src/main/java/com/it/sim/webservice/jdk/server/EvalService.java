package com.it.sim.webservice.jdk.server;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @date 2022-10-24 09:38
 */
@WebService
public class EvalService {

    @WebMethod
    public int add(int a, int b) {
        return a + b;
    }

    @WebMethod
    public int sub(int a, int b) {
        return a - b;
    }


}
