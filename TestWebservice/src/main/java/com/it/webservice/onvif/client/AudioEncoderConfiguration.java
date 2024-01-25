
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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.Duration;
import javax.xml.namespace.QName;
import org.w3c.dom.Element;


/**
 * <p>AudioEncoderConfiguration complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="AudioEncoderConfiguration"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.onvif.org/ver10/schema}ConfigurationEntity"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Encoding" type="{http://www.onvif.org/ver10/schema}AudioEncoding"/&gt;
 *         &lt;element name="Bitrate" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="SampleRate" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="Multicast" type="{http://www.onvif.org/ver10/schema}MulticastConfiguration"/&gt;
 *         &lt;element name="SessionTimeout" type="{http://www.w3.org/2001/XMLSchema}duration"/&gt;
 *         &lt;any processContents='lax' maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;anyAttribute processContents='lax'/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AudioEncoderConfiguration", propOrder = {
    "encoding",
    "bitrate",
    "sampleRate",
    "multicast",
    "sessionTimeout",
    "any"
})
public class AudioEncoderConfiguration
    extends ConfigurationEntity
{

    @XmlElement(name = "Encoding", required = true)
    @XmlSchemaType(name = "string")
    protected AudioEncoding encoding;
    @XmlElement(name = "Bitrate")
    protected int bitrate;
    @XmlElement(name = "SampleRate")
    protected int sampleRate;
    @XmlElement(name = "Multicast", required = true)
    protected MulticastConfiguration multicast;
    @XmlElement(name = "SessionTimeout", required = true)
    protected Duration sessionTimeout;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * 获取encoding属性的值。
     * 
     * @return
     *     possible object is
     *     {@link AudioEncoding }
     *     
     */
    public AudioEncoding getEncoding() {
        return encoding;
    }

    /**
     * 设置encoding属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AudioEncoding }
     *     
     */
    public void setEncoding(AudioEncoding value) {
        this.encoding = value;
    }

    /**
     * 获取bitrate属性的值。
     * 
     */
    public int getBitrate() {
        return bitrate;
    }

    /**
     * 设置bitrate属性的值。
     * 
     */
    public void setBitrate(int value) {
        this.bitrate = value;
    }

    /**
     * 获取sampleRate属性的值。
     * 
     */
    public int getSampleRate() {
        return sampleRate;
    }

    /**
     * 设置sampleRate属性的值。
     * 
     */
    public void setSampleRate(int value) {
        this.sampleRate = value;
    }

    /**
     * 获取multicast属性的值。
     * 
     * @return
     *     possible object is
     *     {@link MulticastConfiguration }
     *     
     */
    public MulticastConfiguration getMulticast() {
        return multicast;
    }

    /**
     * 设置multicast属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link MulticastConfiguration }
     *     
     */
    public void setMulticast(MulticastConfiguration value) {
        this.multicast = value;
    }

    /**
     * 获取sessionTimeout属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getSessionTimeout() {
        return sessionTimeout;
    }

    /**
     * 设置sessionTimeout属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setSessionTimeout(Duration value) {
        this.sessionTimeout = value;
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
