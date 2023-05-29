package com.it.boot.controller.xml.jacksonxml;
 
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
 
/**
 * Created by wl on 2021/6/17.
 */
@Data
@JacksonXmlRootElement(localName = "JacksonXmlBean")
public class JacksonXmlBean {
 
    @JacksonXmlProperty(localName = "id")
    private Integer id;
 
    @JacksonXmlProperty(localName = "name")
    private String name;
 
    @JacksonXmlProperty(localName = "nick_name")
    private String nickName;
 
    @JacksonXmlProperty(localName = "xml_sub_bean")
    private XmlSubBean xmlSubBean;
 
    @JacksonXmlElementWrapper(localName = "sub_bean_list")
    @JacksonXmlProperty(localName = "sub_bean")
    private List<XmlSubBean> subBeanList;

    public static void main(String[] args) throws Exception{
        JacksonXmlBean xmlBean = new JacksonXmlBean();
 
        xmlBean.setId(1);
        xmlBean.setName("wl");
        xmlBean.setNickName("nickName");
 
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
 
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true );
        String xml = xmlMapper.writeValueAsString(xmlBean);
        System.out.println(xml);
 
        JacksonXmlBean bean = xmlMapper.readValue(xml,JacksonXmlBean.class);
        System.out.println(bean);
    }
 
}