
package com.it.sim.webservice.onvif.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ContinuousFocusOptions complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ContinuousFocusOptions"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Speed" type="{http://www.onvif.org/ver10/schema}FloatRange"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContinuousFocusOptions", propOrder = {
    "speed"
})
public class ContinuousFocusOptions {

    @XmlElement(name = "Speed", required = true)
    protected FloatRange speed;

    /**
     * 获取speed属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FloatRange }
     *     
     */
    public FloatRange getSpeed() {
        return speed;
    }

    /**
     * 设置speed属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FloatRange }
     *     
     */
    public void setSpeed(FloatRange value) {
        this.speed = value;
    }

}
