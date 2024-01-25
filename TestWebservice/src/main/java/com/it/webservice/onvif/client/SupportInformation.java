
package com.it.webservice.onvif.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SupportInformation complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="SupportInformation"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Binary" type="{http://www.onvif.org/ver10/schema}AttachmentData" minOccurs="0"/&gt;
 *         &lt;element name="String" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SupportInformation", propOrder = {
    "binary",
    "string"
})
public class SupportInformation {

    @XmlElement(name = "Binary")
    protected AttachmentData binary;
    @XmlElement(name = "String")
    protected String string;

    /**
     * 获取binary属性的值。
     * 
     * @return
     *     possible object is
     *     {@link AttachmentData }
     *     
     */
    public AttachmentData getBinary() {
        return binary;
    }

    /**
     * 设置binary属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AttachmentData }
     *     
     */
    public void setBinary(AttachmentData value) {
        this.binary = value;
    }

    /**
     * 获取string属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getString() {
        return string;
    }

    /**
     * 设置string属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setString(String value) {
        this.string = value;
    }

}
