
package org.onvif.ver10.device.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.onvif.ver10.schema.HostnameInformation;


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
 *         &lt;element name="HostnameInformation" type="{http://www.onvif.org/ver10/schema}HostnameInformation"/>
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
    "hostnameInformation"
})
@XmlRootElement(name = "GetHostnameResponse")
public class GetHostnameResponse {

    @XmlElement(name = "HostnameInformation", required = true)
    protected HostnameInformation hostnameInformation;

    /**
     * ��ȡhostnameInformation���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link HostnameInformation }
     *     
     */
    public HostnameInformation getHostnameInformation() {
        return hostnameInformation;
    }

    /**
     * ����hostnameInformation���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link HostnameInformation }
     *     
     */
    public void setHostnameInformation(HostnameInformation value) {
        this.hostnameInformation = value;
    }

}
