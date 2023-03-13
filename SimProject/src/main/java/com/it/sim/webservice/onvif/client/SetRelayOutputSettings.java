
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
 *         &lt;element name="RelayOutputToken" type="{http://www.onvif.org/ver10/schema}ReferenceToken"/&gt;
 *         &lt;element name="Properties" type="{http://www.onvif.org/ver10/schema}RelayOutputSettings"/&gt;
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
    "relayOutputToken",
    "properties"
})
@XmlRootElement(name = "SetRelayOutputSettings", namespace = "http://www.onvif.org/ver10/device/wsdl")
public class SetRelayOutputSettings {

    @XmlElement(name = "RelayOutputToken", namespace = "http://www.onvif.org/ver10/device/wsdl", required = true)
    protected String relayOutputToken;
    @XmlElement(name = "Properties", namespace = "http://www.onvif.org/ver10/device/wsdl", required = true)
    protected RelayOutputSettings properties;

    /**
     * 获取relayOutputToken属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelayOutputToken() {
        return relayOutputToken;
    }

    /**
     * 设置relayOutputToken属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelayOutputToken(String value) {
        this.relayOutputToken = value;
    }

    /**
     * 获取properties属性的值。
     * 
     * @return
     *     possible object is
     *     {@link RelayOutputSettings }
     *     
     */
    public RelayOutputSettings getProperties() {
        return properties;
    }

    /**
     * 设置properties属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link RelayOutputSettings }
     *     
     */
    public void setProperties(RelayOutputSettings value) {
        this.properties = value;
    }

}
