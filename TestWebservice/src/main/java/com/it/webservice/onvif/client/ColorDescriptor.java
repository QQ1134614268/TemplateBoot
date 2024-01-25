
package com.it.webservice.onvif.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import org.w3c.dom.Element;


/**
 * <p>ColorDescriptor complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ColorDescriptor"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ColorCluster" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Color" type="{http://www.onvif.org/ver10/schema}Color"/&gt;
 *                   &lt;element name="Weight" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/&gt;
 *                   &lt;element name="Covariance" type="{http://www.onvif.org/ver10/schema}ColorCovariance" minOccurs="0"/&gt;
 *                   &lt;any processContents='lax' maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;anyAttribute processContents='lax'/&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Extension" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
 *         &lt;any processContents='lax' maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "ColorDescriptor", propOrder = {
    "colorCluster",
    "extension",
    "any"
})
public class ColorDescriptor {

    @XmlElement(name = "ColorCluster")
    protected List<ColorDescriptor.ColorCluster> colorCluster;
    @XmlElement(name = "Extension")
    protected Object extension;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the colorCluster property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the colorCluster property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getColorCluster().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ColorDescriptor.ColorCluster }
     * 
     * 
     */
    public List<ColorDescriptor.ColorCluster> getColorCluster() {
        if (colorCluster == null) {
            colorCluster = new ArrayList<ColorDescriptor.ColorCluster>();
        }
        return this.colorCluster;
    }

    /**
     * 获取extension属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getExtension() {
        return extension;
    }

    /**
     * 设置extension属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setExtension(Object value) {
        this.extension = value;
    }

    /**
     * Gets the value of the any property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the any property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAny().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * {@link Element }
     * 
     * 
     */
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
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


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="Color" type="{http://www.onvif.org/ver10/schema}Color"/&gt;
     *         &lt;element name="Weight" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/&gt;
     *         &lt;element name="Covariance" type="{http://www.onvif.org/ver10/schema}ColorCovariance" minOccurs="0"/&gt;
     *         &lt;any processContents='lax' maxOccurs="unbounded" minOccurs="0"/&gt;
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
    @XmlType(name = "", propOrder = {
        "color",
        "weight",
        "covariance",
        "any"
    })
    public static class ColorCluster {

        @XmlElement(name = "Color", required = true)
        protected Color color;
        @XmlElement(name = "Weight")
        protected Float weight;
        @XmlElement(name = "Covariance")
        protected ColorCovariance covariance;
        @XmlAnyElement(lax = true)
        protected List<Object> any;
        @XmlAnyAttribute
        private Map<QName, String> otherAttributes = new HashMap<QName, String>();

        /**
         * 获取color属性的值。
         * 
         * @return
         *     possible object is
         *     {@link Color }
         *     
         */
        public Color getColor() {
            return color;
        }

        /**
         * 设置color属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link Color }
         *     
         */
        public void setColor(Color value) {
            this.color = value;
        }

        /**
         * 获取weight属性的值。
         * 
         * @return
         *     possible object is
         *     {@link Float }
         *     
         */
        public Float getWeight() {
            return weight;
        }

        /**
         * 设置weight属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link Float }
         *     
         */
        public void setWeight(Float value) {
            this.weight = value;
        }

        /**
         * 获取covariance属性的值。
         * 
         * @return
         *     possible object is
         *     {@link ColorCovariance }
         *     
         */
        public ColorCovariance getCovariance() {
            return covariance;
        }

        /**
         * 设置covariance属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link ColorCovariance }
         *     
         */
        public void setCovariance(ColorCovariance value) {
            this.covariance = value;
        }

        /**
         * Gets the value of the any property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the any property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAny().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Object }
         * {@link Element }
         * 
         * 
         */
        public List<Object> getAny() {
            if (any == null) {
                any = new ArrayList<Object>();
            }
            return this.any;
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

}
