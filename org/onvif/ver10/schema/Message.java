
package org.onvif.ver10.schema;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * <p>anonymous complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Source" type="{http://www.onvif.org/ver10/schema}ItemList" minOccurs="0"/>
 *         &lt;element name="Key" type="{http://www.onvif.org/ver10/schema}ItemList" minOccurs="0"/>
 *         &lt;element name="Data" type="{http://www.onvif.org/ver10/schema}ItemList" minOccurs="0"/>
 *         &lt;element name="Extension" type="{http://www.onvif.org/ver10/schema}MessageExtension" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="UtcTime" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="PropertyOperation" type="{http://www.onvif.org/ver10/schema}PropertyOperation" />
 *       &lt;anyAttribute processContents='lax'/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "source",
    "key",
    "data",
    "extension"
})
@XmlRootElement(name = "Message")
public class Message {

    @XmlElement(name = "Source")
    protected ItemList source;
    @XmlElement(name = "Key")
    protected ItemList key;
    @XmlElement(name = "Data")
    protected ItemList data;
    @XmlElement(name = "Extension")
    protected MessageExtension extension;
    @XmlAttribute(name = "UtcTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar utcTime;
    @XmlAttribute(name = "PropertyOperation")
    protected PropertyOperation propertyOperation;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * ��ȡsource���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ItemList }
     *     
     */
    public ItemList getSource() {
        return source;
    }

    /**
     * ����source���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ItemList }
     *     
     */
    public void setSource(ItemList value) {
        this.source = value;
    }

    /**
     * ��ȡkey���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ItemList }
     *     
     */
    public ItemList getKey() {
        return key;
    }

    /**
     * ����key���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ItemList }
     *     
     */
    public void setKey(ItemList value) {
        this.key = value;
    }

    /**
     * ��ȡdata���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ItemList }
     *     
     */
    public ItemList getData() {
        return data;
    }

    /**
     * ����data���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ItemList }
     *     
     */
    public void setData(ItemList value) {
        this.data = value;
    }

    /**
     * ��ȡextension���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link MessageExtension }
     *     
     */
    public MessageExtension getExtension() {
        return extension;
    }

    /**
     * ����extension���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link MessageExtension }
     *     
     */
    public void setExtension(MessageExtension value) {
        this.extension = value;
    }

    /**
     * ��ȡutcTime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUtcTime() {
        return utcTime;
    }

    /**
     * ����utcTime���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setUtcTime(XMLGregorianCalendar value) {
        this.utcTime = value;
    }

    /**
     * ��ȡpropertyOperation���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link PropertyOperation }
     *     
     */
    public PropertyOperation getPropertyOperation() {
        return propertyOperation;
    }

    /**
     * ����propertyOperation���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link PropertyOperation }
     *     
     */
    public void setPropertyOperation(PropertyOperation value) {
        this.propertyOperation = value;
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
