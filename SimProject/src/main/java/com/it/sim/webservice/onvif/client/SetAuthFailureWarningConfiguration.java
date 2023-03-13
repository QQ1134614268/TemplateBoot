
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
 *         &lt;element name="Enabled" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="MonitorPeriod" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="MaxAuthFailures" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
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
    "enabled",
    "monitorPeriod",
    "maxAuthFailures"
})
@XmlRootElement(name = "SetAuthFailureWarningConfiguration", namespace = "http://www.onvif.org/ver10/device/wsdl")
public class SetAuthFailureWarningConfiguration {

    @XmlElement(name = "Enabled", namespace = "http://www.onvif.org/ver10/device/wsdl")
    protected boolean enabled;
    @XmlElement(name = "MonitorPeriod", namespace = "http://www.onvif.org/ver10/device/wsdl")
    protected int monitorPeriod;
    @XmlElement(name = "MaxAuthFailures", namespace = "http://www.onvif.org/ver10/device/wsdl")
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
