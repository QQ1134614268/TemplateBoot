
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
 * <p>PTControlDirectionOptions complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="PTControlDirectionOptions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EFlip" type="{http://www.onvif.org/ver10/schema}EFlipOptions" minOccurs="0"/>
 *         &lt;element name="Reverse" type="{http://www.onvif.org/ver10/schema}ReverseOptions" minOccurs="0"/>
 *         &lt;element name="Extension" type="{http://www.onvif.org/ver10/schema}PTControlDirectionOptionsExtension" minOccurs="0"/>
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
@XmlType(name = "PTControlDirectionOptions", propOrder = {
    "eFlip",
    "reverse",
    "extension"
})
public class PTControlDirectionOptions {

    @XmlElement(name = "EFlip")
    protected EFlipOptions eFlip;
    @XmlElement(name = "Reverse")
    protected ReverseOptions reverse;
    @XmlElement(name = "Extension")
    protected PTControlDirectionOptionsExtension extension;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * ��ȡeFlip���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link EFlipOptions }
     *     
     */
    public EFlipOptions getEFlip() {
        return eFlip;
    }

    /**
     * ����eFlip���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link EFlipOptions }
     *     
     */
    public void setEFlip(EFlipOptions value) {
        this.eFlip = value;
    }

    /**
     * ��ȡreverse���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ReverseOptions }
     *     
     */
    public ReverseOptions getReverse() {
        return reverse;
    }

    /**
     * ����reverse���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ReverseOptions }
     *     
     */
    public void setReverse(ReverseOptions value) {
        this.reverse = value;
    }

    /**
     * ��ȡextension���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link PTControlDirectionOptionsExtension }
     *     
     */
    public PTControlDirectionOptionsExtension getExtension() {
        return extension;
    }

    /**
     * ����extension���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link PTControlDirectionOptionsExtension }
     *     
     */
    public void setExtension(PTControlDirectionOptionsExtension value) {
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
