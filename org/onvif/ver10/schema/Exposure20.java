
package org.onvif.ver10.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Type describing the exposure settings.
 * 
 * <p>Exposure20 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="Exposure20">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Mode" type="{http://www.onvif.org/ver10/schema}ExposureMode"/>
 *         &lt;element name="Priority" type="{http://www.onvif.org/ver10/schema}ExposurePriority" minOccurs="0"/>
 *         &lt;element name="Window" type="{http://www.onvif.org/ver10/schema}Rectangle" minOccurs="0"/>
 *         &lt;element name="MinExposureTime" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="MaxExposureTime" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="MinGain" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="MaxGain" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="MinIris" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="MaxIris" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="ExposureTime" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="Gain" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="Iris" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Exposure20", propOrder = {
    "mode",
    "priority",
    "window",
    "minExposureTime",
    "maxExposureTime",
    "minGain",
    "maxGain",
    "minIris",
    "maxIris",
    "exposureTime",
    "gain",
    "iris"
})
public class Exposure20 {

    @XmlElement(name = "Mode", required = true)
    @XmlSchemaType(name = "string")
    protected ExposureMode mode;
    @XmlElement(name = "Priority")
    @XmlSchemaType(name = "string")
    protected ExposurePriority priority;
    @XmlElement(name = "Window")
    protected Rectangle window;
    @XmlElement(name = "MinExposureTime")
    protected Float minExposureTime;
    @XmlElement(name = "MaxExposureTime")
    protected Float maxExposureTime;
    @XmlElement(name = "MinGain")
    protected Float minGain;
    @XmlElement(name = "MaxGain")
    protected Float maxGain;
    @XmlElement(name = "MinIris")
    protected Float minIris;
    @XmlElement(name = "MaxIris")
    protected Float maxIris;
    @XmlElement(name = "ExposureTime")
    protected Float exposureTime;
    @XmlElement(name = "Gain")
    protected Float gain;
    @XmlElement(name = "Iris")
    protected Float iris;

    /**
     * ��ȡmode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ExposureMode }
     *     
     */
    public ExposureMode getMode() {
        return mode;
    }

    /**
     * ����mode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ExposureMode }
     *     
     */
    public void setMode(ExposureMode value) {
        this.mode = value;
    }

    /**
     * ��ȡpriority���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ExposurePriority }
     *     
     */
    public ExposurePriority getPriority() {
        return priority;
    }

    /**
     * ����priority���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ExposurePriority }
     *     
     */
    public void setPriority(ExposurePriority value) {
        this.priority = value;
    }

    /**
     * ��ȡwindow���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Rectangle }
     *     
     */
    public Rectangle getWindow() {
        return window;
    }

    /**
     * ����window���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Rectangle }
     *     
     */
    public void setWindow(Rectangle value) {
        this.window = value;
    }

    /**
     * ��ȡminExposureTime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getMinExposureTime() {
        return minExposureTime;
    }

    /**
     * ����minExposureTime���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setMinExposureTime(Float value) {
        this.minExposureTime = value;
    }

    /**
     * ��ȡmaxExposureTime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getMaxExposureTime() {
        return maxExposureTime;
    }

    /**
     * ����maxExposureTime���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setMaxExposureTime(Float value) {
        this.maxExposureTime = value;
    }

    /**
     * ��ȡminGain���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getMinGain() {
        return minGain;
    }

    /**
     * ����minGain���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setMinGain(Float value) {
        this.minGain = value;
    }

    /**
     * ��ȡmaxGain���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getMaxGain() {
        return maxGain;
    }

    /**
     * ����maxGain���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setMaxGain(Float value) {
        this.maxGain = value;
    }

    /**
     * ��ȡminIris���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getMinIris() {
        return minIris;
    }

    /**
     * ����minIris���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setMinIris(Float value) {
        this.minIris = value;
    }

    /**
     * ��ȡmaxIris���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getMaxIris() {
        return maxIris;
    }

    /**
     * ����maxIris���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setMaxIris(Float value) {
        this.maxIris = value;
    }

    /**
     * ��ȡexposureTime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getExposureTime() {
        return exposureTime;
    }

    /**
     * ����exposureTime���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setExposureTime(Float value) {
        this.exposureTime = value;
    }

    /**
     * ��ȡgain���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getGain() {
        return gain;
    }

    /**
     * ����gain���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setGain(Float value) {
        this.gain = value;
    }

    /**
     * ��ȡiris���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getIris() {
        return iris;
    }

    /**
     * ����iris���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setIris(Float value) {
        this.iris = value;
    }

}
