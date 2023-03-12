
package org.onvif.ver10.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Date complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="Date">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Year" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Month" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Day" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Date", propOrder = {
    "year",
    "month",
    "day"
})
public class Date {

    @XmlElement(name = "Year")
    protected int year;
    @XmlElement(name = "Month")
    protected int month;
    @XmlElement(name = "Day")
    protected int day;

    /**
     * ��ȡyear���Ե�ֵ��
     * 
     */
    public int getYear() {
        return year;
    }

    /**
     * ����year���Ե�ֵ��
     * 
     */
    public void setYear(int value) {
        this.year = value;
    }

    /**
     * ��ȡmonth���Ե�ֵ��
     * 
     */
    public int getMonth() {
        return month;
    }

    /**
     * ����month���Ե�ֵ��
     * 
     */
    public void setMonth(int value) {
        this.month = value;
    }

    /**
     * ��ȡday���Ե�ֵ��
     * 
     */
    public int getDay() {
        return day;
    }

    /**
     * ����day���Ե�ֵ��
     * 
     */
    public void setDay(int value) {
        this.day = value;
    }

}
