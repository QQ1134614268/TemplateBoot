
package com.it.webservice.onvif.client;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * <p>ColorCovariance complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ColorCovariance"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="XX" use="required" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="YY" use="required" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="ZZ" use="required" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="XY" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="XZ" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="YZ" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="Colorspace" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
 *       &lt;anyAttribute processContents='lax'/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ColorCovariance")
public class ColorCovariance {

    @XmlAttribute(name = "XX", required = true)
    protected float xx;
    @XmlAttribute(name = "YY", required = true)
    protected float yy;
    @XmlAttribute(name = "ZZ", required = true)
    protected float zz;
    @XmlAttribute(name = "XY")
    protected Float xy;
    @XmlAttribute(name = "XZ")
    protected Float xz;
    @XmlAttribute(name = "YZ")
    protected Float yz;
    @XmlAttribute(name = "Colorspace")
    @XmlSchemaType(name = "anyURI")
    protected String colorspace;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * 获取xx属性的值。
     * 
     */
    public float getXX() {
        return xx;
    }

    /**
     * 设置xx属性的值。
     * 
     */
    public void setXX(float value) {
        this.xx = value;
    }

    /**
     * 获取yy属性的值。
     * 
     */
    public float getYY() {
        return yy;
    }

    /**
     * 设置yy属性的值。
     * 
     */
    public void setYY(float value) {
        this.yy = value;
    }

    /**
     * 获取zz属性的值。
     * 
     */
    public float getZZ() {
        return zz;
    }

    /**
     * 设置zz属性的值。
     * 
     */
    public void setZZ(float value) {
        this.zz = value;
    }

    /**
     * 获取xy属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getXY() {
        return xy;
    }

    /**
     * 设置xy属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setXY(Float value) {
        this.xy = value;
    }

    /**
     * 获取xz属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getXZ() {
        return xz;
    }

    /**
     * 设置xz属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setXZ(Float value) {
        this.xz = value;
    }

    /**
     * 获取yz属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getYZ() {
        return yz;
    }

    /**
     * 设置yz属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setYZ(Float value) {
        this.yz = value;
    }

    /**
     * 获取colorspace属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColorspace() {
        return colorspace;
    }

    /**
     * 设置colorspace属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColorspace(String value) {
        this.colorspace = value;
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
