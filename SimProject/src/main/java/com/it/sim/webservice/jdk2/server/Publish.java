package com.it.sim.webservice.jdk2.server;


import javax.xml.ws.Endpoint;

public class Publish {
    /**
     * main方法中发布
     */
    public static void main(String[] args) {
        String address = "http://localhost:49002/service/EvalService";
        Endpoint.publish(address, new HelloServiceImpl());
        System.out.println("发布成功: " + address + "?wsdl");
        // wsimport -s . http://localhost:49002/service/EvalService?wsdl
        //    非项目顶级目录, 修改了包名
    }
}
