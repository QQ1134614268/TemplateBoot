package com.it.boot.controller.xml2;
 
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
 
import java.util.ArrayList;
import java.util.List;
 
/**
 * Created by wl on 2021/6/17.
 */
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
 
    public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getNickName() {
        return nickName;
    }
 
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
 
    public XmlSubBean getXmlSubBean() {
        return xmlSubBean;
    }
 
    public void setXmlSubBean(XmlSubBean xmlSubBean) {
        this.xmlSubBean = xmlSubBean;
    }
 
    public List<XmlSubBean> getSubBeanList() {
        return subBeanList;
    }
 
    public void setSubBeanList(List<XmlSubBean> subBeanList) {
        this.subBeanList = subBeanList;
    }
 
    public static class XmlSubBean{
 
        @JacksonXmlProperty(localName = "sub_id")
        private Integer subId;
 
        @JacksonXmlProperty(localName = "sub_name")
        private String subName;
 
        @JacksonXmlProperty(localName = "sub_nick_name")
        private String subNickName;
 
        public Integer getSubId() {
            return subId;
        }
 
        public void setSubId(Integer subId) {
            this.subId = subId;
        }
 
        public String getSubName() {
            return subName;
        }
 
        public void setSubName(String subName) {
            this.subName = subName;
        }
 
        public String getSubNickName() {
            return subNickName;
        }
 
        public void setSubNickName(String subNickName) {
            this.subNickName = subNickName;
        }
    }
 
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