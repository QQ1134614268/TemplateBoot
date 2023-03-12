
package org.onvif.ver10.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Time complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="Time">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Hour" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Minute" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Second" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Time", propOrder = {
    "hour",
    "minute",
    "second"
})
public class Time {

    @XmlElement(name = "Hour")
    protected int hour;
    @XmlElement(name = "Minute")
    protected int minute;
    @XmlElement(name = "Second")
    protected int second;

    /**
     * ��ȡhour���Ե�ֵ��
     * 
     */
    public int getHour() {
        return hour;
    }

    /**
     * ����hour���Ե�ֵ��
     * 
     */
    public void setHour(int value) {
        this.hour = value;
    }

    /**
     * ��ȡminute���Ե�ֵ��
     * 
     */
    public int getMinute() {
        return minute;
    }

    /**
     * ����minute���Ե�ֵ��
     * 
     */
    public void setMinute(int value) {
        this.minute = value;
    }

    /**
     * ��ȡsecond���Ե�ֵ��
     * 
     */
    public int getSecond() {
        return second;
    }

    /**
     * ����second���Ե�ֵ��
     * 
     */
    public void setSecond(int value) {
        this.second = value;
    }

}
