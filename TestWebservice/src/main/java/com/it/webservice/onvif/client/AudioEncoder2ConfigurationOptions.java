
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
 * <p>AudioEncoder2ConfigurationOptions complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="AudioEncoder2ConfigurationOptions"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Encoding" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="BitrateList" type="{http://www.onvif.org/ver10/schema}IntItems"/&gt;
 *         &lt;element name="SampleRateList" type="{http://www.onvif.org/ver10/schema}IntItems"/&gt;
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
@XmlType(name = "AudioEncoder2ConfigurationOptions", propOrder = {
    "encoding",
    "bitrateList",
    "sampleRateList",
    "any"
})
public class AudioEncoder2ConfigurationOptions {

    @XmlElement(name = "Encoding", required = true)
    protected String encoding;
    @XmlElement(name = "BitrateList", required = true)
    protected IntItems bitrateList;
    @XmlElement(name = "SampleRateList", required = true)
    protected IntItems sampleRateList;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * 获取encoding属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEncoding() {
        return encoding;
    }

    /**
     * 设置encoding属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEncoding(String value) {
        this.encoding = value;
    }

    /**
     * 获取bitrateList属性的值。
     * 
     * @return
     *     possible object is
     *     {@link IntItems }
     *     
     */
    public IntItems getBitrateList() {
        return bitrateList;
    }

    /**
     * 设置bitrateList属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link IntItems }
     *     
     */
    public void setBitrateList(IntItems value) {
        this.bitrateList = value;
    }

    /**
     * 获取sampleRateList属性的值。
     * 
     * @return
     *     possible object is
     *     {@link IntItems }
     *     
     */
    public IntItems getSampleRateList() {
        return sampleRateList;
    }

    /**
     * 设置sampleRateList属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link IntItems }
     *     
     */
    public void setSampleRateList(IntItems value) {
        this.sampleRateList = value;
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
