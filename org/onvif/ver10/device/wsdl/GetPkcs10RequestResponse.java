
package org.onvif.ver10.device.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.onvif.ver10.schema.BinaryData;


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
 *         &lt;element name="Pkcs10Request" type="{http://www.onvif.org/ver10/schema}BinaryData"/>
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
    "pkcs10Request"
})
@XmlRootElement(name = "GetPkcs10RequestResponse")
public class GetPkcs10RequestResponse {

    @XmlElement(name = "Pkcs10Request", required = true)
    protected BinaryData pkcs10Request;

    /**
     * ��ȡpkcs10Request���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BinaryData }
     *     
     */
    public BinaryData getPkcs10Request() {
        return pkcs10Request;
    }

    /**
     * ����pkcs10Request���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BinaryData }
     *     
     */
    public void setPkcs10Request(BinaryData value) {
        this.pkcs10Request = value;
    }

}
