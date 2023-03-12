
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
 * <p>ImagingSettings complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ImagingSettings">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BacklightCompensation" type="{http://www.onvif.org/ver10/schema}BacklightCompensation" minOccurs="0"/>
 *         &lt;element name="Brightness" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="ColorSaturation" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="Contrast" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="Exposure" type="{http://www.onvif.org/ver10/schema}Exposure" minOccurs="0"/>
 *         &lt;element name="Focus" type="{http://www.onvif.org/ver10/schema}FocusConfiguration" minOccurs="0"/>
 *         &lt;element name="IrCutFilter" type="{http://www.onvif.org/ver10/schema}IrCutFilterMode" minOccurs="0"/>
 *         &lt;element name="Sharpness" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="WideDynamicRange" type="{http://www.onvif.org/ver10/schema}WideDynamicRange" minOccurs="0"/>
 *         &lt;element name="WhiteBalance" type="{http://www.onvif.org/ver10/schema}WhiteBalance" minOccurs="0"/>
 *         &lt;element name="Extension" type="{http://www.onvif.org/ver10/schema}ImagingSettingsExtension" minOccurs="0"/>
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
@XmlType(name = "ImagingSettings", propOrder = {
    "backlightCompensation",
    "brightness",
    "colorSaturation",
    "contrast",
    "exposure",
    "focus",
    "irCutFilter",
    "sharpness",
    "wideDynamicRange",
    "whiteBalance",
    "extension"
})
public class ImagingSettings {

    @XmlElement(name = "BacklightCompensation")
    protected BacklightCompensation backlightCompensation;
    @XmlElement(name = "Brightness")
    protected Float brightness;
    @XmlElement(name = "ColorSaturation")
    protected Float colorSaturation;
    @XmlElement(name = "Contrast")
    protected Float contrast;
    @XmlElement(name = "Exposure")
    protected Exposure exposure;
    @XmlElement(name = "Focus")
    protected FocusConfiguration focus;
    @XmlElement(name = "IrCutFilter")
    @XmlSchemaType(name = "string")
    protected IrCutFilterMode irCutFilter;
    @XmlElement(name = "Sharpness")
    protected Float sharpness;
    @XmlElement(name = "WideDynamicRange")
    protected WideDynamicRange wideDynamicRange;
    @XmlElement(name = "WhiteBalance")
    protected WhiteBalance whiteBalance;
    @XmlElement(name = "Extension")
    protected ImagingSettingsExtension extension;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * ��ȡbacklightCompensation���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BacklightCompensation }
     *     
     */
    public BacklightCompensation getBacklightCompensation() {
        return backlightCompensation;
    }

    /**
     * ����backlightCompensation���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BacklightCompensation }
     *     
     */
    public void setBacklightCompensation(BacklightCompensation value) {
        this.backlightCompensation = value;
    }

    /**
     * ��ȡbrightness���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getBrightness() {
        return brightness;
    }

    /**
     * ����brightness���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setBrightness(Float value) {
        this.brightness = value;
    }

    /**
     * ��ȡcolorSaturation���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getColorSaturation() {
        return colorSaturation;
    }

    /**
     * ����colorSaturation���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setColorSaturation(Float value) {
        this.colorSaturation = value;
    }

    /**
     * ��ȡcontrast���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getContrast() {
        return contrast;
    }

    /**
     * ����contrast���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setContrast(Float value) {
        this.contrast = value;
    }

    /**
     * ��ȡexposure���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Exposure }
     *     
     */
    public Exposure getExposure() {
        return exposure;
    }

    /**
     * ����exposure���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Exposure }
     *     
     */
    public void setExposure(Exposure value) {
        this.exposure = value;
    }

    /**
     * ��ȡfocus���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link FocusConfiguration }
     *     
     */
    public FocusConfiguration getFocus() {
        return focus;
    }

    /**
     * ����focus���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link FocusConfiguration }
     *     
     */
    public void setFocus(FocusConfiguration value) {
        this.focus = value;
    }

    /**
     * ��ȡirCutFilter���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link IrCutFilterMode }
     *     
     */
    public IrCutFilterMode getIrCutFilter() {
        return irCutFilter;
    }

    /**
     * ����irCutFilter���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link IrCutFilterMode }
     *     
     */
    public void setIrCutFilter(IrCutFilterMode value) {
        this.irCutFilter = value;
    }

    /**
     * ��ȡsharpness���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getSharpness() {
        return sharpness;
    }

    /**
     * ����sharpness���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setSharpness(Float value) {
        this.sharpness = value;
    }

    /**
     * ��ȡwideDynamicRange���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link WideDynamicRange }
     *     
     */
    public WideDynamicRange getWideDynamicRange() {
        return wideDynamicRange;
    }

    /**
     * ����wideDynamicRange���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link WideDynamicRange }
     *     
     */
    public void setWideDynamicRange(WideDynamicRange value) {
        this.wideDynamicRange = value;
    }

    /**
     * ��ȡwhiteBalance���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link WhiteBalance }
     *     
     */
    public WhiteBalance getWhiteBalance() {
        return whiteBalance;
    }

    /**
     * ����whiteBalance���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link WhiteBalance }
     *     
     */
    public void setWhiteBalance(WhiteBalance value) {
        this.whiteBalance = value;
    }

    /**
     * ��ȡextension���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ImagingSettingsExtension }
     *     
     */
    public ImagingSettingsExtension getExtension() {
        return extension;
    }

    /**
     * ����extension���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ImagingSettingsExtension }
     *     
     */
    public void setExtension(ImagingSettingsExtension value) {
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
