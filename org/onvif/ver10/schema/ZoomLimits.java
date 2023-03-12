
package org.onvif.ver10.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ZoomLimits complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ZoomLimits">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Range" type="{http://www.onvif.org/ver10/schema}Space1DDescription"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZoomLimits", propOrder = {
    "range"
})
public class ZoomLimits {

    @XmlElement(name = "Range", required = true)
    protected Space1DDescription range;

    /**
     * ��ȡrange���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Space1DDescription }
     *     
     */
    public Space1DDescription getRange() {
        return range;
    }

    /**
     * ����range���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Space1DDescription }
     *     
     */
    public void setRange(Space1DDescription value) {
        this.range = value;
    }

}
