
package org.onvif.ver10.schema;

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
import javax.xml.namespace.QName;
import org.w3c.dom.Element;


/**
 * <p>AudioEncoderConfigurationOption complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="AudioEncoderConfigurationOption">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Encoding" type="{http://www.onvif.org/ver10/schema}AudioEncoding"/>
 *         &lt;element name="BitrateList" type="{http://www.onvif.org/ver10/schema}IntItems"/>
 *         &lt;element name="SampleRateList" type="{http://www.onvif.org/ver10/schema}IntItems"/>
 *         &lt;any processContents='lax' maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "AudioEncoderConfigurationOption", propOrder = {
    "encoding",
    "bitrateList",
    "sampleRateList",
    "any"
})
public class AudioEncoderConfigurationOption {

    @XmlElement(name = "Encoding", required = true)
    @XmlSchemaType(name = "string")
    protected AudioEncoding encoding;
    @XmlElement(name = "BitrateList", required = true)
    protected IntItems bitrateList;
    @XmlElement(name = "SampleRateList", required = true)
    protected IntItems sampleRateList;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * ��ȡencoding���Ե�ֵ��
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
     * ����encoding���Ե�ֵ��
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
     * ��ȡbitrateList���Ե�ֵ��
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
     * ����bitrateList���Ե�ֵ��
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
     * ��ȡsampleRateList���Ե�ֵ��
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
     * ����sampleRateList���Ե�ֵ��
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
     * {@link Element }
     * {@link Object }
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
