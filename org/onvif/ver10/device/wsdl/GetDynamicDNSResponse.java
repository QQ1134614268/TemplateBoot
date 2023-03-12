
package org.onvif.ver10.device.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.onvif.ver10.schema.DynamicDNSInformation;


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
 *         &lt;element name="DynamicDNSInformation" type="{http://www.onvif.org/ver10/schema}DynamicDNSInformation"/>
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
    "dynamicDNSInformation"
})
@XmlRootElement(name = "GetDynamicDNSResponse")
public class GetDynamicDNSResponse {

    @XmlElement(name = "DynamicDNSInformation", required = true)
    protected DynamicDNSInformation dynamicDNSInformation;

    /**
     * ��ȡdynamicDNSInformation���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link DynamicDNSInformation }
     *     
     */
    public DynamicDNSInformation getDynamicDNSInformation() {
        return dynamicDNSInformation;
    }

    /**
     * ����dynamicDNSInformation���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link DynamicDNSInformation }
     *     
     */
    public void setDynamicDNSInformation(DynamicDNSInformation value) {
        this.dynamicDNSInformation = value;
    }

}
