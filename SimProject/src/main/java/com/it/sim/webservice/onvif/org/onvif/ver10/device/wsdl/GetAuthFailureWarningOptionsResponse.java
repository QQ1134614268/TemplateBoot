
package org.onvif.ver10.device.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.onvif.ver10.schema.IntRange;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MonitorPeriodRange" type="{http://www.onvif.org/ver10/schema}IntRange"/>
 *         &lt;element name="AuthFailureRange" type="{http://www.onvif.org/ver10/schema}IntRange"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "monitorPeriodRange",
    "authFailureRange"
})
@XmlRootElement(name = "GetAuthFailureWarningOptionsResponse")
public class GetAuthFailureWarningOptionsResponse {

    @XmlElement(name = "MonitorPeriodRange", required = true)
    protected IntRange monitorPeriodRange;
    @XmlElement(name = "AuthFailureRange", required = true)
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
