
package org.onvif.ver10.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>H264Configuration complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="H264Configuration">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GovLength" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="H264Profile" type="{http://www.onvif.org/ver10/schema}H264Profile"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "H264Configuration", propOrder = {
    "govLength",
    "h264Profile"
})
public class H264Configuration {

    @XmlElement(name = "GovLength")
    protected int govLength;
    @XmlElement(name = "H264Profile", required = true)
    @XmlSchemaType(name = "string")
    protected H264Profile h264Profile;

    /**
     * ��ȡgovLength���Ե�ֵ��
     * 
     */
    public int getGovLength() {
        return govLength;
    }

    /**
     * ����govLength���Ե�ֵ��
     * 
     */
    public void setGovLength(int value) {
        this.govLength = value;
    }

    /**
     * ��ȡh264Profile���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link H264Profile }
     *     
     */
    public H264Profile getH264Profile() {
        return h264Profile;
    }

    /**
     * ����h264Profile���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link H264Profile }
     *     
     */
    public void setH264Profile(H264Profile value) {
        this.h264Profile = value;
    }

}
