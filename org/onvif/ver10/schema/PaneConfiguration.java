
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
 * Configuration of the streaming and coding settings of a Video window.
 * 
 * <p>PaneConfiguration complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="PaneConfiguration">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PaneName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AudioOutputToken" type="{http://www.onvif.org/ver10/schema}ReferenceToken" minOccurs="0"/>
 *         &lt;element name="AudioSourceToken" type="{http://www.onvif.org/ver10/schema}ReferenceToken" minOccurs="0"/>
 *         &lt;element name="AudioEncoderConfiguration" type="{http://www.onvif.org/ver10/schema}AudioEncoderConfiguration" minOccurs="0"/>
 *         &lt;element name="ReceiverToken" type="{http://www.onvif.org/ver10/schema}ReferenceToken" minOccurs="0"/>
 *         &lt;element name="Token" type="{http://www.onvif.org/ver10/schema}ReferenceToken"/>
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
@XmlType(name = "PaneConfiguration", propOrder = {
    "paneName",
    "audioOutputToken",
    "audioSourceToken",
    "audioEncoderConfiguration",
    "receiverToken",
    "token",
    "any"
})
public class PaneConfiguration {

    @XmlElement(name = "PaneName")
    protected String paneName;
    @XmlElement(name = "AudioOutputToken")
    protected String audioOutputToken;
    @XmlElement(name = "AudioSourceToken")
    protected String audioSourceToken;
    @XmlElement(name = "AudioEncoderConfiguration")
    protected AudioEncoderConfiguration audioEncoderConfiguration;
    @XmlElement(name = "ReceiverToken")
    protected String receiverToken;
    @XmlElement(name = "Token", required = true)
    protected String token;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * ��ȡpaneName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaneName() {
        return paneName;
    }

    /**
     * ����paneName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaneName(String value) {
        this.paneName = value;
    }

    /**
     * ��ȡaudioOutputToken���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAudioOutputToken() {
        return audioOutputToken;
    }

    /**
     * ����audioOutputToken���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAudioOutputToken(String value) {
        this.audioOutputToken = value;
    }

    /**
     * ��ȡaudioSourceToken���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAudioSourceToken() {
        return audioSourceToken;
    }

    /**
     * ����audioSourceToken���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAudioSourceToken(String value) {
        this.audioSourceToken = value;
    }

    /**
     * ��ȡaudioEncoderConfiguration���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link AudioEncoderConfiguration }
     *     
     */
    public AudioEncoderConfiguration getAudioEncoderConfiguration() {
        return audioEncoderConfiguration;
    }

    /**
     * ����audioEncoderConfiguration���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link AudioEncoderConfiguration }
     *     
     */
    public void setAudioEncoderConfiguration(AudioEncoderConfiguration value) {
        this.audioEncoderConfiguration = value;
    }

    /**
     * ��ȡreceiverToken���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReceiverToken() {
        return receiverToken;
    }

    /**
     * ����receiverToken���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReceiverToken(String value) {
        this.receiverToken = value;
    }

    /**
     * ��ȡtoken���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToken() {
        return token;
    }

    /**
     * ����token���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToken(String value) {
        this.token = value;
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
