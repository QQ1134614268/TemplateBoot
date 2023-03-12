
package org.onvif.ver10.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Range of values greater equal Min value and less equal Max value.
 * 
 * <p>FloatRange complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="FloatRange">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Min" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="Max" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FloatRange", propOrder = {
    "min",
    "max"
})
public class FloatRange {

    @XmlElement(name = "Min")
    protected float min;
    @XmlElement(name = "Max")
    protected float max;

    /**
     * ��ȡmin���Ե�ֵ��
     * 
     */
    public float getMin() {
        return min;
    }

    /**
     * ����min���Ե�ֵ��
     * 
     */
    public void setMin(float value) {
        this.min = value;
    }

    /**
     * ��ȡmax���Ե�ֵ��
     * 
     */
    public float getMax() {
        return max;
    }

    /**
     * ����max���Ե�ֵ��
     * 
     */
    public void setMax(float value) {
        this.max = value;
    }

}
