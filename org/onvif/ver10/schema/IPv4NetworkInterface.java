
package org.onvif.ver10.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>IPv4NetworkInterface complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="IPv4NetworkInterface">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Enabled" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Config" type="{http://www.onvif.org/ver10/schema}IPv4Configuration"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IPv4NetworkInterface", propOrder = {
    "enabled",
    "config"
})
public class IPv4NetworkInterface {

    @XmlElement(name = "Enabled")
    protected boolean enabled;
    @XmlElement(name = "Config", required = true)
    protected IPv4Configuration config;

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
     * ��ȡconfig���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link IPv4Configuration }
     *     
     */
    public IPv4Configuration getConfig() {
        return config;
    }

    /**
     * ����config���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link IPv4Configuration }
     *     
     */
    public void setConfig(IPv4Configuration value) {
        this.config = value;
    }

}
