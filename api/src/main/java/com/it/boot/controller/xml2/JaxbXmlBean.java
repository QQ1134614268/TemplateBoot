package com.it.boot.controller.xml2;
 
import java.io.ByteArrayOutputStream;
 
import javax.xml.bind.JAXBContext;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
 
/**
 * Created by wl on 2021/6/18.
 */
@XmlRootElement(name = "JaxbXmlBean")
public class JaxbXmlBean {
    private Integer id;
 
    private String name;
 
    private String nickName;
 
    private XmlSubBean xmlSubBean;
 
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
 
        private Integer subId;
 
        private String subName;
 
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
        String xml = new String(bos.toByteArray());
        System.out.println(xml);
 
        JaxbXmlBean xmlBean1 = (JaxbXmlBean) context.createUnmarshaller().unmarshal(new ByteArrayInputStream(xml.getBytes()));
        System.out.println(xmlBean1);
    }
}