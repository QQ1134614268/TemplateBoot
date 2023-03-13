
package com.it.sim.webservice.onvif.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SystemLog" type="{http://www.onvif.org/ver10/schema}SystemLog"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "systemLog"
})
@XmlRootElement(name = "GetSystemLogResponse", namespace = "http://www.onvif.org/ver10/device/wsdl")
public class GetSystemLogResponse {

    @XmlElement(name = "SystemLog", namespace = "http://www.onvif.org/ver10/device/wsdl", required = true)
    protected SystemLog systemLog;

    /**
     * 获取systemLog属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SystemLog }
     *     
     */
    public SystemLog getSystemLog() {
        return systemLog;
    }

    /**
     * 设置systemLog属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SystemLog }
     *     
     */
    public void setSystemLog(SystemLog value) {
        this.systemLog = value;
    }

}
