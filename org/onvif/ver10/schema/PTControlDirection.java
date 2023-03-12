
package org.onvif.ver10.schema;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * <p>PTControlDirection complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="PTControlDirection">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EFlip" type="{http://www.onvif.org/ver10/schema}EFlip" minOccurs="0"/>
 *         &lt;element name="Reverse" type="{http://www.onvif.org/ver10/schema}Reverse" minOccurs="0"/>
 *         &lt;element name="Extension" type="{http://www.onvif.org/ver10/schema}PTControlDirectionExtension" minOccurs="0"/>
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
@XmlType(name = "PTControlDirection", propOrder = {
    "eFlip",
    "reverse",
    "extension"
})
public class PTControlDirection {

    @XmlElement(name = "EFlip")
    protected EFlip eFlip;
    @XmlElement(name = "Reverse")
    protected Reverse reverse;
    @XmlElement(name = "Extension")
    protected PTControlDirectionExtension extension;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * ��ȡeFlip���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link EFlip }
     *     
     */
    public EFlip getEFlip() {
        return eFlip;
    }

    /**
     * ����eFlip���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link EFlip }
     *     
     */
    public void setEFlip(EFlip value) {
        this.eFlip = value;
    }

    /**
     * ��ȡreverse���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Reverse }
     *     
     */
    public Reverse getReverse() {
        return reverse;
    }

    /**
     * ����reverse���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Reverse }
     *     
     */
    public void setReverse(Reverse value) {
        this.reverse = value;
    }

    /**
     * ��ȡextension���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link PTControlDirectionExtension }
     *     
     */
    public PTControlDirectionExtension getExtension() {
        return extension;
    }

    /**
     * ����extension���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link PTControlDirectionExtension }
     *     
     */
    public void setExtension(PTControlDirectionExtension value) {
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
