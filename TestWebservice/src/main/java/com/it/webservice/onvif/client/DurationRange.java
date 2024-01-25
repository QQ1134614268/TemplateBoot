
package com.it.webservice.onvif.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.Duration;


/**
 * Range of duration greater equal Min duration and less equal Max duration.
 *             
 * 
 * <p>DurationRange complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="DurationRange"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Min" type="{http://www.w3.org/2001/XMLSchema}duration"/&gt;
 *         &lt;element name="Max" type="{http://www.w3.org/2001/XMLSchema}duration"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DurationRange", propOrder = {
    "min",
    "max"
})
public class DurationRange {

    @XmlElement(name = "Min", required = true)
    protected Duration min;
    @XmlElement(name = "Max", required = true)
    protected Duration max;

    /**
     * 获取min属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getMin() {
        return min;
    }

    /**
     * 设置min属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setMin(Duration value) {
        this.min = value;
    }

    /**
     * 获取max属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getMax() {
        return max;
    }

    /**
     * 设置max属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setMax(Duration value) {
        this.max = value;
    }

}
