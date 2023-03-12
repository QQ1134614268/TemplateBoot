
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
 * <p>TrackAttributes complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="TrackAttributes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TrackInformation" type="{http://www.onvif.org/ver10/schema}TrackInformation"/>
 *         &lt;element name="VideoAttributes" type="{http://www.onvif.org/ver10/schema}VideoAttributes" minOccurs="0"/>
 *         &lt;element name="AudioAttributes" type="{http://www.onvif.org/ver10/schema}AudioAttributes" minOccurs="0"/>
 *         &lt;element name="MetadataAttributes" type="{http://www.onvif.org/ver10/schema}MetadataAttributes" minOccurs="0"/>
 *         &lt;element name="Extension" type="{http://www.onvif.org/ver10/schema}TrackAttributesExtension" minOccurs="0"/>
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
@XmlType(name = "TrackAttributes", propOrder = {
    "trackInformation",
    "videoAttributes",
    "audioAttributes",
    "metadataAttributes",
    "extension"
})
public class TrackAttributes {

    @XmlElement(name = "TrackInformation", required = true)
    protected TrackInformation trackInformation;
    @XmlElement(name = "VideoAttributes")
    protected VideoAttributes videoAttributes;
    @XmlElement(name = "AudioAttributes")
    protected AudioAttributes audioAttributes;
    @XmlElement(name = "MetadataAttributes")
    protected MetadataAttributes metadataAttributes;
    @XmlElement(name = "Extension")
    protected TrackAttributesExtension extension;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * ��ȡtrackInformation���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link TrackInformation }
     *     
     */
    public TrackInformation getTrackInformation() {
        return trackInformation;
    }

    /**
     * ����trackInformation���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link TrackInformation }
     *     
     */
    public void setTrackInformation(TrackInformation value) {
        this.trackInformation = value;
    }

    /**
     * ��ȡvideoAttributes���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link VideoAttributes }
     *     
     */
    public VideoAttributes getVideoAttributes() {
        return videoAttributes;
    }

    /**
     * ����videoAttributes���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link VideoAttributes }
     *     
     */
    public void setVideoAttributes(VideoAttributes value) {
        this.videoAttributes = value;
    }

    /**
     * ��ȡaudioAttributes���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link AudioAttributes }
     *     
     */
    public AudioAttributes getAudioAttributes() {
        return audioAttributes;
    }

    /**
     * ����audioAttributes���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link AudioAttributes }
     *     
     */
    public void setAudioAttributes(AudioAttributes value) {
        this.audioAttributes = value;
    }

    /**
     * ��ȡmetadataAttributes���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link MetadataAttributes }
     *     
     */
    public MetadataAttributes getMetadataAttributes() {
        return metadataAttributes;
    }

    /**
     * ����metadataAttributes���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link MetadataAttributes }
     *     
     */
    public void setMetadataAttributes(MetadataAttributes value) {
        this.metadataAttributes = value;
    }

    /**
     * ��ȡextension���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link TrackAttributesExtension }
     *     
     */
    public TrackAttributesExtension getExtension() {
        return extension;
    }

    /**
     * ����extension���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link TrackAttributesExtension }
     *     
     */
    public void setExtension(TrackAttributesExtension value) {
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
