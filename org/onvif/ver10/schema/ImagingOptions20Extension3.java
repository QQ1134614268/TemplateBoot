
package org.onvif.ver10.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ImagingOptions20Extension3 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ImagingOptions20Extension3">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ToneCompensationOptions" type="{http://www.onvif.org/ver10/schema}ToneCompensationOptions" minOccurs="0"/>
 *         &lt;element name="DefoggingOptions" type="{http://www.onvif.org/ver10/schema}DefoggingOptions" minOccurs="0"/>
 *         &lt;element name="NoiseReductionOptions" type="{http://www.onvif.org/ver10/schema}NoiseReductionOptions" minOccurs="0"/>
 *         &lt;element name="Extension" type="{http://www.onvif.org/ver10/schema}ImagingOptions20Extension4" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ImagingOptions20Extension3", propOrder = {
    "toneCompensationOptions",
    "defoggingOptions",
    "noiseReductionOptions",
    "extension"
})
public class ImagingOptions20Extension3 {

    @XmlElement(name = "ToneCompensationOptions")
    protected ToneCompensationOptions toneCompensationOptions;
    @XmlElement(name = "DefoggingOptions")
    protected DefoggingOptions defoggingOptions;
    @XmlElement(name = "NoiseReductionOptions")
    protected NoiseReductionOptions noiseReductionOptions;
    @XmlElement(name = "Extension")
    protected ImagingOptions20Extension4 extension;

    /**
     * ��ȡtoneCompensationOptions���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ToneCompensationOptions }
     *     
     */
    public ToneCompensationOptions getToneCompensationOptions() {
        return toneCompensationOptions;
    }

    /**
     * ����toneCompensationOptions���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ToneCompensationOptions }
     *     
     */
    public void setToneCompensationOptions(ToneCompensationOptions value) {
        this.toneCompensationOptions = value;
    }

    /**
     * ��ȡdefoggingOptions���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link DefoggingOptions }
     *     
     */
    public DefoggingOptions getDefoggingOptions() {
        return defoggingOptions;
    }

    /**
     * ����defoggingOptions���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link DefoggingOptions }
     *     
     */
    public void setDefoggingOptions(DefoggingOptions value) {
        this.defoggingOptions = value;
    }

    /**
     * ��ȡnoiseReductionOptions���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link NoiseReductionOptions }
     *     
     */
    public NoiseReductionOptions getNoiseReductionOptions() {
        return noiseReductionOptions;
    }

    /**
     * ����noiseReductionOptions���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link NoiseReductionOptions }
     *     
     */
    public void setNoiseReductionOptions(NoiseReductionOptions value) {
        this.noiseReductionOptions = value;
    }

    /**
     * ��ȡextension���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ImagingOptions20Extension4 }
     *     
     */
    public ImagingOptions20Extension4 getExtension() {
        return extension;
    }

    /**
     * ����extension���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ImagingOptions20Extension4 }
     *     
     */
    public void setExtension(ImagingOptions20Extension4 value) {
        this.extension = value;
    }

}
