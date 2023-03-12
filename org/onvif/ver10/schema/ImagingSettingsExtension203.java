
package org.onvif.ver10.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ImagingSettingsExtension203 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ImagingSettingsExtension203">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ToneCompensation" type="{http://www.onvif.org/ver10/schema}ToneCompensation" minOccurs="0"/>
 *         &lt;element name="Defogging" type="{http://www.onvif.org/ver10/schema}Defogging" minOccurs="0"/>
 *         &lt;element name="NoiseReduction" type="{http://www.onvif.org/ver10/schema}NoiseReduction" minOccurs="0"/>
 *         &lt;element name="Extension" type="{http://www.onvif.org/ver10/schema}ImagingSettingsExtension204" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ImagingSettingsExtension203", propOrder = {
    "toneCompensation",
    "defogging",
    "noiseReduction",
    "extension"
})
public class ImagingSettingsExtension203 {

    @XmlElement(name = "ToneCompensation")
    protected ToneCompensation toneCompensation;
    @XmlElement(name = "Defogging")
    protected Defogging defogging;
    @XmlElement(name = "NoiseReduction")
    protected NoiseReduction noiseReduction;
    @XmlElement(name = "Extension")
    protected ImagingSettingsExtension204 extension;

    /**
     * ��ȡtoneCompensation���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ToneCompensation }
     *     
     */
    public ToneCompensation getToneCompensation() {
        return toneCompensation;
    }

    /**
     * ����toneCompensation���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ToneCompensation }
     *     
     */
    public void setToneCompensation(ToneCompensation value) {
        this.toneCompensation = value;
    }

    /**
     * ��ȡdefogging���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Defogging }
     *     
     */
    public Defogging getDefogging() {
        return defogging;
    }

    /**
     * ����defogging���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Defogging }
     *     
     */
    public void setDefogging(Defogging value) {
        this.defogging = value;
    }

    /**
     * ��ȡnoiseReduction���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link NoiseReduction }
     *     
     */
    public NoiseReduction getNoiseReduction() {
        return noiseReduction;
    }

    /**
     * ����noiseReduction���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link NoiseReduction }
     *     
     */
    public void setNoiseReduction(NoiseReduction value) {
        this.noiseReduction = value;
    }

    /**
     * ��ȡextension���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ImagingSettingsExtension204 }
     *     
     */
    public ImagingSettingsExtension204 getExtension() {
        return extension;
    }

    /**
     * ����extension���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ImagingSettingsExtension204 }
     *     
     */
    public void setExtension(ImagingSettingsExtension204 value) {
        this.extension = value;
    }

}
