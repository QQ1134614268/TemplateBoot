
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
 *         &lt;element name="FromDHCP" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "fromDHCP"
})
@XmlRootElement(name = "SetHostnameFromDHCP")
public class SetHostnameFromDHCP {

    @XmlElement(name = "FromDHCP")
    protected boolean fromDHCP;

    /**
     * ��ȡfromDHCP���Ե�ֵ��
     * 
     */
    public boolean isFromDHCP() {
        return fromDHCP;
    }

    /**
     * ����fromDHCP���Ե�ֵ��
     * 
     */
    public void setFromDHCP(boolean value) {
        this.fromDHCP = value;
    }

}
