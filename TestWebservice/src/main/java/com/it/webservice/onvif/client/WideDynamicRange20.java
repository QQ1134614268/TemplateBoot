
package com.it.webservice.onvif.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Type describing whether WDR mode is enabled or disabled (on/off).
 * 
 * <p>WideDynamicRange20 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="WideDynamicRange20"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Mode" type="{http://www.onvif.org/ver10/schema}WideDynamicMode"/&gt;
 *         &lt;element name="Level" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WideDynamicRange20", propOrder = {
    "mode",
    "level"
})
public class WideDynamicRange20 {

    @XmlElement(name = "Mode", required = true)
    @XmlSchemaType(name = "string")
    protected WideDynamicMode mode;
    @XmlElement(name = "Level")
    protected Float level;

    /**
     * 获取mode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link WideDynamicMode }
     *     
     */
    public WideDynamicMode getMode() {
        return mode;
    }

    /**
     * 设置mode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link WideDynamicMode }
     *     
     */
    public void setMode(WideDynamicMode value) {
        this.mode = value;
    }

    /**
     * 获取level属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getLevel() {
        return level;
    }

    /**
     * 设置level属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setLevel(Float value) {
        this.level = value;
    }

}
