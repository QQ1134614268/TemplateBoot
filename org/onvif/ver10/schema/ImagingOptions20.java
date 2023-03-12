
package org.onvif.ver10.schema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * <p>ImagingOptions20 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ImagingOptions20">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BacklightCompensation" type="{http://www.onvif.org/ver10/schema}BacklightCompensationOptions20" minOccurs="0"/>
 *         &lt;element name="Brightness" type="{http://www.onvif.org/ver10/schema}FloatRange" minOccurs="0"/>
 *         &lt;element name="ColorSaturation" type="{http://www.onvif.org/ver10/schema}FloatRange" minOccurs="0"/>
 *         &lt;element name="Contrast" type="{http://www.onvif.org/ver10/schema}FloatRange" minOccurs="0"/>
 *         &lt;element name="Exposure" type="{http://www.onvif.org/ver10/schema}ExposureOptions20" minOccurs="0"/>
 *         &lt;element name="Focus" type="{http://www.onvif.org/ver10/schema}FocusOptions20" minOccurs="0"/>
 *         &lt;element name="IrCutFilterModes" type="{http://www.onvif.org/ver10/schema}IrCutFilterMode" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Sharpness" type="{http://www.onvif.org/ver10/schema}FloatRange" minOccurs="0"/>
 *         &lt;element name="WideDynamicRange" type="{http://www.onvif.org/ver10/schema}WideDynamicRangeOptions20" minOccurs="0"/>
 *         &lt;element name="WhiteBalance" type="{http://www.onvif.org/ver10/schema}WhiteBalanceOptions20" minOccurs="0"/>
 *         &lt;element name="Extension" type="{http://www.onvif.org/ver10/schema}ImagingOptions20Extension" minOccurs="0"/>
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
@XmlType(name = "ImagingOptions20", propOrder = {
    "backlightCompensation",
    "brightness",
    "colorSaturation",
    "contrast",
    "exposure",
    "focus",
    "irCutFilterModes",
    "sharpness",
    "wideDynamicRange",
    "whiteBalance",
    "extension"
})
public class ImagingOptions20 {

    @XmlElement(name = "BacklightCompensation")
    protected BacklightCompensationOptions20 backlightCompensation;
    @XmlElement(name = "Brightness")
    protected FloatRange brightness;
    @XmlElement(name = "ColorSaturation")
    protected FloatRange colorSaturation;
    @XmlElement(name = "Contrast")
    protected FloatRange contrast;
    @XmlElement(name = "Exposure")
    protected ExposureOptions20 exposure;
    @XmlElement(name = "Focus")
    protected FocusOptions20 focus;
    @XmlElement(name = "IrCutFilterModes")
    @XmlSchemaType(name = "string")
    protected List<IrCutFilterMode> irCutFilterModes;
    @XmlElement(name = "Sharpness")
    protected FloatRange sharpness;
    @XmlElement(name = "WideDynamicRange")
    protected WideDynamicRangeOptions20 wideDynamicRange;
    @XmlElement(name = "WhiteBalance")
    protected WhiteBalanceOptions20 whiteBalance;
    @XmlElement(name = "Extension")
    protected ImagingOptions20Extension extension;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * ��ȡbacklightCompensation���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BacklightCompensationOptions20 }
     *     
     */
    public BacklightCompensationOptions20 getBacklightCompensation() {
        return backlightCompensation;
    }

    /**
     * ����backlightCompensation���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BacklightCompensationOptions20 }
     *     
     */
    public void setBacklightCompensation(BacklightCompensationOptions20 value) {
        this.backlightCompensation = value;
    }

    /**
     * ��ȡbrightness���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link FloatRange }
     *     
     */
    public FloatRange getBrightness() {
        return brightness;
    }

    /**
     * ����brightness���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link FloatRange }
     *     
     */
    public void setBrightness(FloatRange value) {
        this.brightness = value;
    }

    /**
     * ��ȡcolorSaturation���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link FloatRange }
     *     
     */
    public FloatRange getColorSaturation() {
        return colorSaturation;
    }

    /**
     * ����colorSaturation���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link FloatRange }
     *     
     */
    public void setColorSaturation(FloatRange value) {
        this.colorSaturation = value;
    }

    /**
     * ��ȡcontrast���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link FloatRange }
     *     
     */
    public FloatRange getContrast() {
        return contrast;
    }

    /**
     * ����contrast���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link FloatRange }
     *     
     */
    public void setContrast(FloatRange value) {
        this.contrast = value;
    }

    /**
     * ��ȡexposure���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ExposureOptions20 }
     *     
     */
    public ExposureOptions20 getExposure() {
        return exposure;
    }

    /**
     * ����exposure���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ExposureOptions20 }
     *     
     */
    public void setExposure(ExposureOptions20 value) {
        this.exposure = value;
    }

    /**
     * ��ȡfocus���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link FocusOptions20 }
     *     
     */
    public FocusOptions20 getFocus() {
        return focus;
    }

    /**
     * ����focus���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link FocusOptions20 }
     *     
     */
    public void setFocus(FocusOptions20 value) {
        this.focus = value;
    }

    /**
     * Gets the value of the irCutFilterModes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the irCutFilterModes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIrCutFilterModes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IrCutFilterMode }
     * 
     * 
     */
    public List<IrCutFilterMode> getIrCutFilterModes() {
        if (irCutFilterModes == null) {
            irCutFilterModes = new ArrayList<IrCutFilterMode>();
        }
        return this.irCutFilterModes;
    }

    /**
     * ��ȡsharpness���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link FloatRange }
     *     
     */
    public FloatRange getSharpness() {
        return sharpness;
    }

    /**
     * ����sharpness���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link FloatRange }
     *     
     */
    public void setSharpness(FloatRange value) {
        this.sharpness = value;
    }

    /**
     * ��ȡwideDynamicRange���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link WideDynamicRangeOptions20 }
     *     
     */
    public WideDynamicRangeOptions20 getWideDynamicRange() {
        return wideDynamicRange;
    }

    /**
     * ����wideDynamicRange���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link WideDynamicRangeOptions20 }
     *     
     */
    public void setWideDynamicRange(WideDynamicRangeOptions20 value) {
        this.wideDynamicRange = value;
    }

    /**
     * ��ȡwhiteBalance���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link WhiteBalanceOptions20 }
     *     
     */
    public WhiteBalanceOptions20 getWhiteBalance() {
        return whiteBalance;
    }

    /**
     * ����whiteBalance���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link WhiteBalanceOptions20 }
     *     
     */
    public void setWhiteBalance(WhiteBalanceOptions20 value) {
        this.whiteBalance = value;
    }

    /**
     * ��ȡextension���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ImagingOptions20Extension }
     *     
     */
    public ImagingOptions20Extension getExtension() {
        return extension;
    }

    /**
     * ����extension���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ImagingOptions20Extension }
     *     
     */
    public void setExtension(ImagingOptions20Extension value) {
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
