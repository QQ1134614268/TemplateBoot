
package com.it.sim.webservice.onvif.client;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * <p>Transformation complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="Transformation"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Translate" type="{http://www.onvif.org/ver10/schema}Vector" minOccurs="0"/&gt;
 *         &lt;element name="Scale" type="{http://www.onvif.org/ver10/schema}Vector" minOccurs="0"/&gt;
 *         &lt;element name="Extension" type="{http://www.onvif.org/ver10/schema}TransformationExtension" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;anyAttribute processContents='lax'/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Transformation", propOrder = {
    "translate",
    "scale",
    "extension"
})
public class Transformation {

    @XmlElement(name = "Translate")
    protected Vector translate;
    @XmlElement(name = "Scale")
    protected Vector scale;
    @XmlElement(name = "Extension")
    protected TransformationExtension extension;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * 获取translate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Vector }
     *     
     */
    public Vector getTranslate() {
        return translate;
    }

    /**
     * 设置translate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Vector }
     *     
     */
    public void setTranslate(Vector value) {
        this.translate = value;
    }

    /**
     * 获取scale属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Vector }
     *     
     */
    public Vector getScale() {
        return scale;
    }

    /**
     * 设置scale属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Vector }
     *     
     */
    public void setScale(Vector value) {
        this.scale = value;
    }

    /**
     * 获取extension属性的值。
     * 
     * @return
     *     possible object is
     *     {@link TransformationExtension }
     *     
     */
    public TransformationExtension getExtension() {
        return extension;
    }

    /**
     * 设置extension属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link TransformationExtension }
     *     
     */
    public void setExtension(TransformationExtension value) {
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
