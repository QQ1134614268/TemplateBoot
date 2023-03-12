
package org.onvif.ver10.device.wsdl;

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
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Enabled" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="MonitorPeriod" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="MaxAuthFailures" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "enabled",
    "monitorPeriod",
    "maxAuthFailures"
})
@XmlRootElement(name = "GetAuthFailureWarningConfigurationResponse")
public class GetAuthFailureWarningConfigurationResponse {

    @XmlElement(name = "Enabled")
    protected boolean enabled;
    @XmlElement(name = "MonitorPeriod")
    protected int monitorPeriod;
    @XmlElement(name = "MaxAuthFailures")
    protected int maxAuthFailures;

    /**
     * 获取enabled属性的值。
     * 
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * 设置enabled属性的值。
     * 
     */
    public void setEnabled(boolean value) {
        this.enabled = value;
    }

    /**
     * 获取monitorPeriod属性的值。
     * 
     */
    public int getMonitorPeriod() {
        return monitorPeriod;
    }

    /**
     * 设置monitorPeriod属性的值。
     * 
     */
    public void setMonitorPeriod(int value) {
        this.monitorPeriod = value;
    }

    /**
     * 获取maxAuthFailures属性的值。
     * 
     */
    public int getMaxAuthFailures() {
        return maxAuthFailures;
    }

    /**
     * 设置maxAuthFailures属性的值。
     * 
     */
    public void setMaxAuthFailures(int value) {
        this.maxAuthFailures = value;
    }

}
