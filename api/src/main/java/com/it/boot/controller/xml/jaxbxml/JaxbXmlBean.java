package com.it.boot.controller.xml.jaxbxml;
 
import lombok.Data;

import java.io.ByteArrayOutputStream;
 
import javax.xml.bind.JAXBContext;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
 
/**
 * Created by wl on 2021/6/18.
 */
@Data
@XmlRootElement(name = "JaxbXmlBean")
public class JaxbXmlBean {
    private Integer id;
 
    private String name;
 
    private String nickName;
 
    private XmlSubBean xmlSubBean;
 
    private List<XmlSubBean> subBeanList;

    public static void main(String[] args) throws Exception{
        JaxbXmlBean xmlBean = new JaxbXmlBean();
        xmlBean.setId(1);
        xmlBean.setName("wl");
        xmlBean.setNickName("你好");
 
        XmlSubBean subBean = new XmlSubBean();
        subBean.setSubId(12);
        subBean.setSubName("sub_wl");
        subBean.setSubNickName("sub_nickName");
 
        xmlBean.setXmlSubBean(subBean);
        List<XmlSubBean> list = new ArrayList<>();
        list.add(subBean);
        list.add(subBean);
        list.add(subBean);
        xmlBean.setSubBeanList(list);
 
        JAXBContext context = JAXBContext.newInstance(JaxbXmlBean.class);
       
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        context.createMarshaller().marshal(xmlBean,bos);
        String xml = bos.toString();
        System.out.println(xml);
 
        JaxbXmlBean xmlBean1 = (JaxbXmlBean) context.createUnmarshaller().unmarshal(new ByteArrayInputStream(xml.getBytes()));
        System.out.println(xmlBean1);
    }
}