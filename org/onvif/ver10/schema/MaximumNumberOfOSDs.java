
package org.onvif.ver10.schema;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * <p>MaximumNumberOfOSDs complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="MaximumNumberOfOSDs">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="Total" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Image" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="PlainText" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Date" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Time" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="DateAndTime" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;anyAttribute processContents='lax'/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MaximumNumberOfOSDs")
public class MaximumNumberOfOSDs {

    @XmlAttribute(name = "Total", required = true)
    protected int total;
    @XmlAttribute(name = "Image")
    protected Integer image;
    @XmlAttribute(name = "PlainText")
    protected Integer plainText;
    @XmlAttribute(name = "Date")
    protected Integer date;
    @XmlAttribute(name = "Time")
    protected Integer time;
    @XmlAttribute(name = "DateAndTime")
    protected Integer dateAndTime;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * ��ȡtotal���Ե�ֵ��
     * 
     */
    public int getTotal() {
        return total;
    }

    /**
     * ����total���Ե�ֵ��
     * 
     */
    public void setTotal(int value) {
        this.total = value;
    }

    /**
     * ��ȡimage���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getImage() {
        return image;
    }

    /**
     * ����image���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setImage(Integer value) {
        this.image = value;
    }

    /**
     * ��ȡplainText���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPlainText() {
        return plainText;
    }

    /**
     * ����plainText���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPlainText(Integer value) {
        this.plainText = value;
    }

    /**
     * ��ȡdate���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDate() {
        return date;
    }

    /**
     * ����date���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDate(Integer value) {
        this.date = value;
    }

    /**
     * ��ȡtime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTime() {
        return time;
    }

    /**
     * ����time���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTime(Integer value) {
        this.time = value;
    }

    /**
     * ��ȡdateAndTime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDateAndTime() {
        return dateAndTime;
    }

    /**
     * ����dateAndTime���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDateAndTime(Integer value) {
        this.dateAndTime = value;
    }

    /**
     * Gets a map that contains attributes that aren't bound to any typed property on this class.
     * 
     * <p>
     * the map is keyed by the name of the attribute and 
     * the value is the string value of the attribute.
     * 
     * the map returned by this method is live, and you can add new attribute
     * by updating the map directly. Because of this design, there's no setter.
     * 
     * 
     * @return
     *     always non-null
     */
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

}
