
package org.onvif.ver10.schema;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * <p>OSDTextConfiguration complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="OSDTextConfiguration">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DateFormat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TimeFormat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FontSize" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="FontColor" type="{http://www.onvif.org/ver10/schema}OSDColor" minOccurs="0"/>
 *         &lt;element name="BackgroundColor" type="{http://www.onvif.org/ver10/schema}OSDColor" minOccurs="0"/>
 *         &lt;element name="PlainText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Extension" type="{http://www.onvif.org/ver10/schema}OSDTextConfigurationExtension" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="IsPersistentText" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;anyAttribute processContents='lax'/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OSDTextConfiguration", propOrder = {
    "type",
    "dateFormat",
    "timeFormat",
    "fontSize",
    "fontColor",
    "backgroundColor",
    "plainText",
    "extension"
})
public class OSDTextConfiguration {

    @XmlElement(name = "Type", required = true)
    protected String type;
    @XmlElement(name = "DateFormat")
    protected String dateFormat;
    @XmlElement(name = "TimeFormat")
    protected String timeFormat;
    @XmlElement(name = "FontSize")
    protected Integer fontSize;
    @XmlElement(name = "FontColor")
    protected OSDColor fontColor;
    @XmlElement(name = "BackgroundColor")
    protected OSDColor backgroundColor;
    @XmlElement(name = "PlainText")
    protected String plainText;
    @XmlElement(name = "Extension")
    protected OSDTextConfigurationExtension extension;
    @XmlAttribute(name = "IsPersistentText")
    protected Boolean isPersistentText;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * ��ȡtype���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * ����type���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * ��ȡdateFormat���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateFormat() {
        return dateFormat;
    }

    /**
     * ����dateFormat���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateFormat(String value) {
        this.dateFormat = value;
    }

    /**
     * ��ȡtimeFormat���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeFormat() {
        return timeFormat;
    }

    /**
     * ����timeFormat���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeFormat(String value) {
        this.timeFormat = value;
    }

    /**
     * ��ȡfontSize���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFontSize() {
        return fontSize;
    }

    /**
     * ����fontSize���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFontSize(Integer value) {
        this.fontSize = value;
    }

    /**
     * ��ȡfontColor���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link OSDColor }
     *     
     */
    public OSDColor getFontColor() {
        return fontColor;
    }

    /**
     * ����fontColor���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link OSDColor }
     *     
     */
    public void setFontColor(OSDColor value) {
        this.fontColor = value;
    }

    /**
     * ��ȡbackgroundColor���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link OSDColor }
     *     
     */
    public OSDColor getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * ����backgroundColor���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link OSDColor }
     *     
     */
    public void setBackgroundColor(OSDColor value) {
        this.backgroundColor = value;
    }

    /**
     * ��ȡplainText���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlainText() {
        return plainText;
    }

    /**
     * ����plainText���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlainText(String value) {
        this.plainText = value;
    }

    /**
     * ��ȡextension���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link OSDTextConfigurationExtension }
     *     
     */
    public OSDTextConfigurationExtension getExtension() {
        return extension;
    }

    /**
     * ����extension���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link OSDTextConfigurationExtension }
     *     
     */
    public void setExtension(OSDTextConfigurationExtension value) {
        this.extension = value;
    }

    /**
     * ��ȡisPersistentText���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsPersistentText() {
        return isPersistentText;
    }

    /**
     * ����isPersistentText���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsPersistentText(Boolean value) {
        this.isPersistentText = value;
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
