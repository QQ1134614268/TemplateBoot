
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
 *         &lt;element name="Pkcs10Request" type="{http://www.onvif.org/ver10/schema}BinaryData"/&gt;
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
    "pkcs10Request"
})
@XmlRootElement(name = "GetPkcs10RequestResponse", namespace = "http://www.onvif.org/ver10/device/wsdl")
public class GetPkcs10RequestResponse {

    @XmlElement(name = "Pkcs10Request", namespace = "http://www.onvif.org/ver10/device/wsdl", required = true)
    protected BinaryData pkcs10Request;

    /**
     * 获取pkcs10Request属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BinaryData }
     *     
     */
    public BinaryData getPkcs10Request() {
        return pkcs10Request;
    }

    /**
     * 设置pkcs10Request属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BinaryData }
     *     
     */
    public void setPkcs10Request(BinaryData value) {
        this.pkcs10Request = value;
    }

}
