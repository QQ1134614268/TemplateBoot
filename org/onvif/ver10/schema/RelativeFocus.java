
package org.onvif.ver10.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>RelativeFocus complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="RelativeFocus">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Distance" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="Speed" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RelativeFocus", propOrder = {
    "distance",
    "speed"
})
public class RelativeFocus {

    @XmlElement(name = "Distance")
    protected float distance;
    @XmlElement(name = "Speed")
    protected Float speed;

    /**
     * ��ȡdistance���Ե�ֵ��
     * 
     */
    public float getDistance() {
        return distance;
    }

    /**
     * ����distance���Ե�ֵ��
     * 
     */
    public void setDistance(float value) {
        this.distance = value;
    }

    /**
     * ��ȡspeed���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getSpeed() {
        return speed;
    }

    /**
     * ����speed���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setSpeed(Float value) {
        this.speed = value;
    }

}
