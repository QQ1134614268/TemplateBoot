
package org.onvif.ver10.device.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.onvif.ver10.schema.IPAddressFilter;


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
 *         &lt;element name="IPAddressFilter" type="{http://www.onvif.org/ver10/schema}IPAddressFilter"/>
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
    "ipAddressFilter"
})
@XmlRootElement(name = "GetIPAddressFilterResponse")
public class GetIPAddressFilterResponse {

    @XmlElement(name = "IPAddressFilter", required = true)
    protected IPAddressFilter ipAddressFilter;

    /**
     * ��ȡipAddressFilter���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link IPAddressFilter }
     *     
     */
    public IPAddressFilter getIPAddressFilter() {
        return ipAddressFilter;
    }

    /**
     * ����ipAddressFilter���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link IPAddressFilter }
     *     
     */
    public void setIPAddressFilter(IPAddressFilter value) {
        this.ipAddressFilter = value;
    }

}
