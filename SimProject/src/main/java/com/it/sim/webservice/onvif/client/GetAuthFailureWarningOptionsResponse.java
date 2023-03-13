
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
 *         &lt;element name="MonitorPeriodRange" type="{http://www.onvif.org/ver10/schema}IntRange"/&gt;
 *         &lt;element name="AuthFailureRange" type="{http://www.onvif.org/ver10/schema}IntRange"/&gt;
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
    "monitorPeriodRange",
    "authFailureRange"
})
@XmlRootElement(name = "GetAuthFailureWarningOptionsResponse", namespace = "http://www.onvif.org/ver10/device/wsdl")
public class GetAuthFailureWarningOptionsResponse {

    @XmlElement(name = "MonitorPeriodRange", namespace = "http://www.onvif.org/ver10/device/wsdl", required = true)
    protected IntRange monitorPeriodRange;
    @XmlElement(name = "AuthFailureRange", namespace = "http://www.onvif.org/ver10/device/wsdl", required = true)
    protected IntRange authFailureRange;

    /**
     * 获取monitorPeriodRange属性的值。
     * 
     * @return
     *     possible object is
     *     {@link IntRange }
     *     
     */
    public IntRange getMonitorPeriodRange() {
        return monitorPeriodRange;
    }

    /**
     * 设置monitorPeriodRange属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link IntRange }
     *     
     */
    public void setMonitorPeriodRange(IntRange value) {
        this.monitorPeriodRange = value;
    }

    /**
     * 获取authFailureRange属性的值。
     * 
     * @return
     *     possible object is
     *     {@link IntRange }
     *     
     */
    public IntRange getAuthFailureRange() {
        return authFailureRange;
    }

    /**
     * 设置authFailureRange属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link IntRange }
     *     
     */
    public void setAuthFailureRange(IntRange value) {
        this.authFailureRange = value;
    }

}
