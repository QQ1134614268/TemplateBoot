
package org.onvif.ver10.device.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.onvif.ver10.schema.CertificateInformation;


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
 *         &lt;element name="CertificateInformation" type="{http://www.onvif.org/ver10/schema}CertificateInformation"/>
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
    "certificateInformation"
})
@XmlRootElement(name = "GetCertificateInformationResponse")
public class GetCertificateInformationResponse {

    @XmlElement(name = "CertificateInformation", required = true)
    protected CertificateInformation certificateInformation;

    /**
     * ��ȡcertificateInformation���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CertificateInformation }
     *     
     */
    public CertificateInformation getCertificateInformation() {
        return certificateInformation;
    }

    /**
     * ����certificateInformation���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CertificateInformation }
     *     
     */
    public void setCertificateInformation(CertificateInformation value) {
        this.certificateInformation = value;
    }

}
