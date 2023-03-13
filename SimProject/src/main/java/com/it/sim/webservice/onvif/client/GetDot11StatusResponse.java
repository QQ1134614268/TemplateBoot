
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
 *         &lt;element name="Status" type="{http://www.onvif.org/ver10/schema}Dot11Status"/&gt;
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
    "status"
})
@XmlRootElement(name = "GetDot11StatusResponse", namespace = "http://www.onvif.org/ver10/device/wsdl")
public class GetDot11StatusResponse {

    @XmlElement(name = "Status", namespace = "http://www.onvif.org/ver10/device/wsdl", required = true)
    protected Dot11Status status;

    /**
     * 获取status属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Dot11Status }
     *     
     */
    public Dot11Status getStatus() {
        return status;
    }

    /**
     * 设置status属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Dot11Status }
     *     
     */
    public void setStatus(Dot11Status value) {
        this.status = value;
    }

}
