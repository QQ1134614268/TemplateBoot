
package com.it.webservice.onvif.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>PanTiltLimits complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="PanTiltLimits"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Range" type="{http://www.onvif.org/ver10/schema}Space2DDescription"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PanTiltLimits", propOrder = {
    "range"
})
public class PanTiltLimits {

    @XmlElement(name = "Range", required = true)
    protected Space2DDescription range;

    /**
     * 获取range属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Space2DDescription }
     *     
     */
    public Space2DDescription getRange() {
        return range;
    }

    /**
     * 设置range属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Space2DDescription }
     *     
     */
    public void setRange(Space2DDescription value) {
        this.range = value;
    }

}
