
package com.it.sim.webservice.onvif.client;

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
 * <p>G711DecOptions complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="G711DecOptions"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Bitrate" type="{http://www.onvif.org/ver10/schema}IntItems"/&gt;
 *         &lt;element name="SampleRateRange" type="{http://www.onvif.org/ver10/schema}IntItems"/&gt;
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
@XmlType(name = "G711DecOptions", propOrder = {
    "bitrate",
    "sampleRateRange",
    "any"
})
public class G711DecOptions {

    @XmlElement(name = "Bitrate", required = true)
    protected IntItems bitrate;
    @XmlElement(name = "SampleRateRange", required = true)
    protected IntItems sampleRateRange;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * 获取bitrate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link IntItems }
     *     
     */
    public IntItems getBitrate() {
        return bitrate;
    }

    /**
     * 设置bitrate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link IntItems }
     *     
     */
    public void setBitrate(IntItems value) {
        this.bitrate = value;
    }

    /**
     * 获取sampleRateRange属性的值。
     * 
     * @return
     *     possible object is
     *     {@link IntItems }
     *     
     */
    public IntItems getSampleRateRange() {
        return sampleRateRange;
    }

    /**
     * 设置sampleRateRange属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link IntItems }
     *     
     */
    public void setSampleRateRange(IntItems value) {
        this.sampleRateRange = value;
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
