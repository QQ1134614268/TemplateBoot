
package org.onvif.ver10.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Range of values greater equal Min value and less equal Max value.
 * 
 * <p>IntRange complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="IntRange">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Min" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Max" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IntRange", propOrder = {
    "min",
    "max"
})
public class IntRange {

    @XmlElement(name = "Min")
    protected int min;
    @XmlElement(name = "Max")
    protected int max;

    /**
     * ��ȡmin���Ե�ֵ��
     * 
     */
    public int getMin() {
        return min;
    }

    /**
     * ����min���Ե�ֵ��
     * 
     */
    public void setMin(int value) {
        this.min = value;
    }

    /**
     * ��ȡmax���Ե�ֵ��
     * 
     */
    public int getMax() {
        return max;
    }

    /**
     * ����max���Ե�ֵ��
     * 
     */
    public void setMax(int value) {
        this.max = value;
    }

}
