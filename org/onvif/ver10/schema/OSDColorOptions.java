
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
 * Describe the option of the color and its transparency.
 * 
 * <p>OSDColorOptions complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="OSDColorOptions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Color" type="{http://www.onvif.org/ver10/schema}ColorOptions" minOccurs="0"/>
 *         &lt;element name="Transparent" type="{http://www.onvif.org/ver10/schema}IntRange" minOccurs="0"/>
 *         &lt;element name="Extension" type="{http://www.onvif.org/ver10/schema}OSDColorOptionsExtension" minOccurs="0"/>
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
@XmlType(name = "OSDColorOptions", propOrder = {
    "color",
    "transparent",
    "extension"
})
public class OSDColorOptions {

    @XmlElement(name = "Color")
    protected ColorOptions color;
    @XmlElement(name = "Transparent")
    protected IntRange transparent;
    @XmlElement(name = "Extension")
    protected OSDColorOptionsExtension extension;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * ��ȡcolor���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ColorOptions }
     *     
     */
    public ColorOptions getColor() {
        return color;
    }

    /**
     * ����color���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ColorOptions }
     *     
     */
    public void setColor(ColorOptions value) {
        this.color = value;
    }

    /**
     * ��ȡtransparent���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link IntRange }
     *     
     */
    public IntRange getTransparent() {
        return transparent;
    }

    /**
     * ����transparent���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link IntRange }
     *     
     */
    public void setTransparent(IntRange value) {
        this.transparent = value;
    }

    /**
     * ��ȡextension���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link OSDColorOptionsExtension }
     *     
     */
    public OSDColorOptionsExtension getExtension() {
        return extension;
    }

    /**
     * ����extension���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link OSDColorOptionsExtension }
     *     
     */
    public void setExtension(OSDColorOptionsExtension value) {
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
