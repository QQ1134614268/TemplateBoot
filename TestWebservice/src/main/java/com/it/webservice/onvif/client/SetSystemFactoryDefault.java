
package com.it.webservice.onvif.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="FactoryDefault" type="{http://www.onvif.org/ver10/schema}FactoryDefaultType"/&gt;
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
    "factoryDefault"
})
@XmlRootElement(name = "SetSystemFactoryDefault", namespace = "http://www.onvif.org/ver10/device/wsdl")
public class SetSystemFactoryDefault {

    @XmlElement(name = "FactoryDefault", namespace = "http://www.onvif.org/ver10/device/wsdl", required = true)
    @XmlSchemaType(name = "string")
    protected FactoryDefaultType factoryDefault;

    /**
     * 获取factoryDefault属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FactoryDefaultType }
     *     
     */
    public FactoryDefaultType getFactoryDefault() {
        return factoryDefault;
    }

    /**
     * 设置factoryDefault属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FactoryDefaultType }
     *     
     */
    public void setFactoryDefault(FactoryDefaultType value) {
        this.factoryDefault = value;
    }

}
