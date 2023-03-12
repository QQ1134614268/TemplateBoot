
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
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import org.w3c.dom.Element;


/**
 * This type contains the Audio and Video coding capabilities of a display service.
 *             
 * 
 * <p>CodingCapabilities complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="CodingCapabilities">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AudioEncodingCapabilities" type="{http://www.onvif.org/ver10/schema}AudioEncoderConfigurationOptions" minOccurs="0"/>
 *         &lt;element name="AudioDecodingCapabilities" type="{http://www.onvif.org/ver10/schema}AudioDecoderConfigurationOptions" minOccurs="0"/>
 *         &lt;element name="VideoDecodingCapabilities" type="{http://www.onvif.org/ver10/schema}VideoDecoderConfigurationOptions"/>
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
@XmlType(name = "CodingCapabilities", propOrder = {
    "audioEncodingCapabilities",
    "audioDecodingCapabilities",
    "videoDecodingCapabilities",
    "any"
})
public class CodingCapabilities {

    @XmlElement(name = "AudioEncodingCapabilities")
    protected AudioEncoderConfigurationOptions audioEncodingCapabilities;
    @XmlElement(name = "AudioDecodingCapabilities")
    protected AudioDecoderConfigurationOptions audioDecodingCapabilities;
    @XmlElement(name = "VideoDecodingCapabilities", required = true)
    protected VideoDecoderConfigurationOptions videoDecodingCapabilities;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * ��ȡaudioEncodingCapabilities���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link AudioEncoderConfigurationOptions }
     *     
     */
    public AudioEncoderConfigurationOptions getAudioEncodingCapabilities() {
        return audioEncodingCapabilities;
    }

    /**
     * ����audioEncodingCapabilities���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link AudioEncoderConfigurationOptions }
     *     
     */
    public void setAudioEncodingCapabilities(AudioEncoderConfigurationOptions value) {
        this.audioEncodingCapabilities = value;
    }

    /**
     * ��ȡaudioDecodingCapabilities���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link AudioDecoderConfigurationOptions }
     *     
     */
    public AudioDecoderConfigurationOptions getAudioDecodingCapabilities() {
        return audioDecodingCapabilities;
    }

    /**
     * ����audioDecodingCapabilities���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link AudioDecoderConfigurationOptions }
     *     
     */
    public void setAudioDecodingCapabilities(AudioDecoderConfigurationOptions value) {
        this.audioDecodingCapabilities = value;
    }

    /**
     * ��ȡvideoDecodingCapabilities���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link VideoDecoderConfigurationOptions }
     *     
     */
    public VideoDecoderConfigurationOptions getVideoDecodingCapabilities() {
        return videoDecodingCapabilities;
    }

    /**
     * ����videoDecodingCapabilities���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link VideoDecoderConfigurationOptions }
     *     
     */
    public void setVideoDecodingCapabilities(VideoDecoderConfigurationOptions value) {
        this.videoDecodingCapabilities = value;
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
