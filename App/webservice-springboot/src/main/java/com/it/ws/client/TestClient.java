package com.it.ws.client;

import com.it.ws.service.User;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import javax.xml.namespace.QName;

public class TestClient {
    public static void main(String[] args) {
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://localhost:8080/student-service/user?wsdl");
        // 设置出口拦截器，拦截器实现 org.apache.cxf.interceptor.Interceptor 接口即可
//        client.getOutInterceptors().add(new CustomInterceptor());
        Object[] objects;
        try {
            // p1:服务所在命名空间，p2:方法名
            QName opName = new QName("http://service.ws.it.com/", "getById");
            User user = new User();
            user.setId(3L);
            objects = client.invoke(opName, user);
            System.out.println("响应 : " + objects[0]);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
