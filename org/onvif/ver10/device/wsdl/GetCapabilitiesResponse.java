
package org.onvif.ver10.device.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.onvif.ver10.schema.Capabilities;


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
 *         &lt;element name="Capabilities" type="{http://www.onvif.org/ver10/schema}Capabilities"/>
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
    "capabilities"
})
@XmlRootElement(name = "GetCapabilitiesResponse")
public class GetCapabilitiesResponse {

    @XmlElement(name = "Capabilities", required = true)
    protected Capabilities capabilities;

    /**
     * ��ȡcapabilities���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Capabilities }
     *     
     */
    public Capabilities getCapabilities() {
        return capabilities;
    }

    /**
     * ����capabilities���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Capabilities }
     *     
     */
    public void setCapabilities(Capabilities value) {
        this.capabilities = value;
    }

}
