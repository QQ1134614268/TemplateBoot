package com.it.webservice.cxf.service;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

public class Pub {
    public static void main(String[] args) {
        JaxWsServerFactoryBean jaxWsServerFactoryBean = new JaxWsServerFactoryBean();
        jaxWsServerFactoryBean.setAddress("http://127.0.0.1:9999/hihi");
        jaxWsServerFactoryBean.setServiceClass(IHelloService.class);
        jaxWsServerFactoryBean.setServiceBean(new HelloServiceImpl());
        jaxWsServerFactoryBean.create();
        System.out.println("发布成功: " + "http://127.0.0.1:9999/hihi?wsdl");
        // D:\dev\apache-cxf-3.5.4\bin\WSDL2Java -encoding utf-8 -autoNameResolution -p com.it.webservice.cxf.client http://127.0.0.1:9999/hihi?wsdl
    }
}
