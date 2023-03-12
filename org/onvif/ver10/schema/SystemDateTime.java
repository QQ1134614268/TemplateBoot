
package org.onvif.ver10.schema;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * General date time inforamtion returned by the GetSystemDateTime method.
 * 
 * <p>SystemDateTime complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="SystemDateTime">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DateTimeType" type="{http://www.onvif.org/ver10/schema}SetDateTimeType"/>
 *         &lt;element name="DaylightSavings" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="TimeZone" type="{http://www.onvif.org/ver10/schema}TimeZone" minOccurs="0"/>
 *         &lt;element name="UTCDateTime" type="{http://www.onvif.org/ver10/schema}DateTime" minOccurs="0"/>
 *         &lt;element name="LocalDateTime" type="{http://www.onvif.org/ver10/schema}DateTime" minOccurs="0"/>
 *         &lt;element name="Extension" type="{http://www.onvif.org/ver10/schema}SystemDateTimeExtension" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;anyAttribute processContents='lax'/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SystemDateTime", propOrder = {
    "dateTimeType",
    "daylightSavings",
    "timeZone",
    "utcDateTime",
    "localDateTime",
    "extension"
})
public class SystemDateTime {

    @XmlElement(name = "DateTimeType", required = true)
    @XmlSchemaType(name = "string")
    protected SetDateTimeType dateTimeType;
    @XmlElement(name = "DaylightSavings")
    protected boolean daylightSavings;
    @XmlElement(name = "TimeZone")
    protected TimeZone timeZone;
    @XmlElement(name = "UTCDateTime")
    protected DateTime utcDateTime;
    @XmlElement(name = "LocalDateTime")
    protected DateTime localDateTime;
    @XmlElement(name = "Extension")
    protected SystemDateTimeExtension extension;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * ��ȡdateTimeType���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link SetDateTimeType }
     *     
     */
    public SetDateTimeType getDateTimeType() {
        return dateTimeType;
    }

    /**
     * ����dateTimeType���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link SetDateTimeType }
     *     
     */
    public void setDateTimeType(SetDateTimeType value) {
        this.dateTimeType = value;
    }

    /**
     * ��ȡdaylightSavings���Ե�ֵ��
     * 
     */
    public boolean isDaylightSavings() {
        return daylightSavings;
    }

    /**
     * ����daylightSavings���Ե�ֵ��
     * 
     */
    public void setDaylightSavings(boolean value) {
        this.daylightSavings = value;
    }

    /**
     * ��ȡtimeZone���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link TimeZone }
     *     
     */
    public TimeZone getTimeZone() {
        return timeZone;
    }

    /**
     * ����timeZone���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link TimeZone }
     *     
     */
    public void setTimeZone(TimeZone value) {
        this.timeZone = value;
    }

    /**
     * ��ȡutcDateTime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link DateTime }
     *     
     */
    public DateTime getUTCDateTime() {
        return utcDateTime;
    }

    /**
     * ����utcDateTime���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link DateTime }
     *     
     */
    public void setUTCDateTime(DateTime value) {
        this.utcDateTime = value;
    }

    /**
     * ��ȡlocalDateTime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link DateTime }
     *     
     */
    public DateTime getLocalDateTime() {
        return localDateTime;
    }

    /**
     * ����localDateTime���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link DateTime }
     *     
     */
    public void setLocalDateTime(DateTime value) {
        this.localDateTime = value;
    }

    /**
     * ��ȡextension���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link SystemDateTimeExtension }
     *     
     */
    public SystemDateTimeExtension getExtension() {
        return extension;
    }

    /**
     * ����extension���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link SystemDateTimeExtension }
     *     
     */
    public void setExtension(SystemDateTimeExtension value) {
        this.extension = value;
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
