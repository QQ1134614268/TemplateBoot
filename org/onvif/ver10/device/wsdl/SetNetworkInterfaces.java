
package org.onvif.ver10.device.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.onvif.ver10.schema.NetworkInterfaceSetConfiguration;


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
 *         &lt;element name="InterfaceToken" type="{http://www.onvif.org/ver10/schema}ReferenceToken"/>
 *         &lt;element name="NetworkInterface" type="{http://www.onvif.org/ver10/schema}NetworkInterfaceSetConfiguration"/>
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
    "interfaceToken",
    "networkInterface"
})
@XmlRootElement(name = "SetNetworkInterfaces")
public class SetNetworkInterfaces {

    @XmlElement(name = "InterfaceToken", required = true)
    protected String interfaceToken;
    @XmlElement(name = "NetworkInterface", required = true)
    protected NetworkInterfaceSetConfiguration networkInterface;

    /**
     * ��ȡinterfaceToken���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInterfaceToken() {
        return interfaceToken;
    }

    /**
     * ����interfaceToken���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInterfaceToken(String value) {
        this.interfaceToken = value;
    }

    /**
     * ��ȡnetworkInterface���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link NetworkInterfaceSetConfiguration }
     *     
     */
    public NetworkInterfaceSetConfiguration getNetworkInterface() {
        return networkInterface;
    }

    /**
     * ����networkInterface���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link NetworkInterfaceSetConfiguration }
     *     
     */
    public void setNetworkInterface(NetworkInterfaceSetConfiguration value) {
        this.networkInterface = value;
    }

}
