
package org.onvif.ver10.schema;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * <p>OSDConfiguration complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="OSDConfiguration">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.onvif.org/ver10/schema}DeviceEntity">
 *       &lt;sequence>
 *         &lt;element name="VideoSourceConfigurationToken" type="{http://www.onvif.org/ver10/schema}OSDReference"/>
 *         &lt;element name="Type" type="{http://www.onvif.org/ver10/schema}OSDType"/>
 *         &lt;element name="Position" type="{http://www.onvif.org/ver10/schema}OSDPosConfiguration"/>
 *         &lt;element name="TextString" type="{http://www.onvif.org/ver10/schema}OSDTextConfiguration" minOccurs="0"/>
 *         &lt;element name="Image" type="{http://www.onvif.org/ver10/schema}OSDImgConfiguration" minOccurs="0"/>
 *         &lt;element name="Extension" type="{http://www.onvif.org/ver10/schema}OSDConfigurationExtension" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;anyAttribute processContents='lax'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OSDConfiguration", propOrder = {
    "videoSourceConfigurationToken",
    "type",
    "position",
    "textString",
    "image",
    "extension"
})
public class OSDConfiguration
    extends DeviceEntity
{

    @XmlElement(name = "VideoSourceConfigurationToken", required = true)
    protected OSDReference videoSourceConfigurationToken;
    @XmlElement(name = "Type", required = true)
    @XmlSchemaType(name = "string")
    protected OSDType type;
    @XmlElement(name = "Position", required = true)
    protected OSDPosConfiguration position;
    @XmlElement(name = "TextString")
    protected OSDTextConfiguration textString;
    @XmlElement(name = "Image")
    protected OSDImgConfiguration image;
    @XmlElement(name = "Extension")
    protected OSDConfigurationExtension extension;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * ��ȡvideoSourceConfigurationToken���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link OSDReference }
     *     
     */
    public OSDReference getVideoSourceConfigurationToken() {
        return videoSourceConfigurationToken;
    }

    /**
     * ����videoSourceConfigurationToken���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link OSDReference }
     *     
     */
    public void setVideoSourceConfigurationToken(OSDReference value) {
        this.videoSourceConfigurationToken = value;
    }

    /**
     * ��ȡtype���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link OSDType }
     *     
     */
    public OSDType getType() {
        return type;
    }

    /**
     * ����type���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link OSDType }
     *     
     */
    public void setType(OSDType value) {
        this.type = value;
    }

    /**
     * ��ȡposition���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link OSDPosConfiguration }
     *     
     */
    public OSDPosConfiguration getPosition() {
        return position;
    }

    /**
     * ����position���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link OSDPosConfiguration }
     *     
     */
    public void setPosition(OSDPosConfiguration value) {
        this.position = value;
    }

    /**
     * ��ȡtextString���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link OSDTextConfiguration }
     *     
     */
    public OSDTextConfiguration getTextString() {
        return textString;
    }

    /**
     * ����textString���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link OSDTextConfiguration }
     *     
     */
    public void setTextString(OSDTextConfiguration value) {
        this.textString = value;
    }

    /**
     * ��ȡimage���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link OSDImgConfiguration }
     *     
     */
    public OSDImgConfiguration getImage() {
        return image;
    }

    /**
     * ����image���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link OSDImgConfiguration }
     *     
     */
    public void setImage(OSDImgConfiguration value) {
        this.image = value;
    }

    /**
     * ��ȡextension���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link OSDConfigurationExtension }
     *     
     */
    public OSDConfigurationExtension getExtension() {
        return extension;
    }

    /**
     * ����extension���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link OSDConfigurationExtension }
     *     
     */
    public void setExtension(OSDConfigurationExtension value) {
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
