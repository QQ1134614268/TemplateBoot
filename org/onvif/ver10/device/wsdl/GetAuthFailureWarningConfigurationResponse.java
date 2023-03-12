
package org.onvif.ver10.device.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡenabled���Ե�ֵ��
     * 
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * ����enabled���Ե�ֵ��
     * 
     */
    public void setEnabled(boolean value) {
        this.enabled = value;
    }

    /**
     * ��ȡmonitorPeriod���Ե�ֵ��
     * 
     */
    public int getMonitorPeriod() {
        return monitorPeriod;
    }

    /**
     * ����monitorPeriod���Ե�ֵ��
     * 
     */
    public void setMonitorPeriod(int value) {
        this.monitorPeriod = value;
    }

    /**
     * ��ȡmaxAuthFailures���Ե�ֵ��
     * 
     */
    public int getMaxAuthFailures() {
        return maxAuthFailures;
    }

    /**
     * ����maxAuthFailures���Ե�ֵ��
     * 
     */
    public void setMaxAuthFailures(int value) {
        this.maxAuthFailures = value;
    }

}
