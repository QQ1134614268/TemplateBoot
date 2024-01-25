package com.it.webservice.jdk.server;


import javax.xml.ws.Endpoint;

public class Publish {
    /**
     * main方法中发布
     */
    public static void main(String[] args) {
        String address = "http://localhost:49001/service/EvalService";
        Endpoint.publish(address, new EvalService());
        System.out.println("发布成功: " + address + "?wsdl");
        // cd $project_home/src/main/java
        // wsimport -encoding utf-8 -s . -p com.it.webservice.jdk.client -extension -Xnocompile http://localhost:49001/service/EvalService?wsdl
    }
}
