
package org.onvif.ver10.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>AbsoluteFocusOptions complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="AbsoluteFocusOptions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Position" type="{http://www.onvif.org/ver10/schema}FloatRange"/>
 *         &lt;element name="Speed" type="{http://www.onvif.org/ver10/schema}FloatRange" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbsoluteFocusOptions", propOrder = {
    "position",
    "speed"
})
public class AbsoluteFocusOptions {

    @XmlElement(name = "Position", required = true)
    protected FloatRange position;
    @XmlElement(name = "Speed")
    protected FloatRange speed;

    /**
     * ��ȡposition���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link FloatRange }
     *     
     */
    public FloatRange getPosition() {
        return position;
    }

    /**
     * ����position���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link FloatRange }
     *     
     */
    public void setPosition(FloatRange value) {
        this.position = value;
    }

    /**
     * ��ȡspeed���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link FloatRange }
     *     
     */
    public FloatRange getSpeed() {
        return speed;
    }

    /**
     * ����speed���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link FloatRange }
     *     
     */
    public void setSpeed(FloatRange value) {
        this.speed = value;
    }

}
