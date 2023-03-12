
package org.onvif.ver10.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Exposure complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="Exposure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Mode" type="{http://www.onvif.org/ver10/schema}ExposureMode"/>
 *         &lt;element name="Priority" type="{http://www.onvif.org/ver10/schema}ExposurePriority"/>
 *         &lt;element name="Window" type="{http://www.onvif.org/ver10/schema}Rectangle"/>
 *         &lt;element name="MinExposureTime" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="MaxExposureTime" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="MinGain" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="MaxGain" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="MinIris" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="MaxIris" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="ExposureTime" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="Gain" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="Iris" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Exposure", propOrder = {
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
public class Exposure {

    @XmlElement(name = "Mode", required = true)
    @XmlSchemaType(name = "string")
    protected ExposureMode mode;
    @XmlElement(name = "Priority", required = true)
    @XmlSchemaType(name = "string")
    protected ExposurePriority priority;
    @XmlElement(name = "Window", required = true)
    protected Rectangle window;
    @XmlElement(name = "MinExposureTime")
    protected float minExposureTime;
    @XmlElement(name = "MaxExposureTime")
    protected float maxExposureTime;
    @XmlElement(name = "MinGain")
    protected float minGain;
    @XmlElement(name = "MaxGain")
    protected float maxGain;
    @XmlElement(name = "MinIris")
    protected float minIris;
    @XmlElement(name = "MaxIris")
    protected float maxIris;
    @XmlElement(name = "ExposureTime")
    protected float exposureTime;
    @XmlElement(name = "Gain")
    protected float gain;
    @XmlElement(name = "Iris")
    protected float iris;

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
     */
    public float getMinExposureTime() {
        return minExposureTime;
    }

    /**
     * ����minExposureTime���Ե�ֵ��
     * 
     */
    public void setMinExposureTime(float value) {
        this.minExposureTime = value;
    }

    /**
     * ��ȡmaxExposureTime���Ե�ֵ��
     * 
     */
    public float getMaxExposureTime() {
        return maxExposureTime;
    }

    /**
     * ����maxExposureTime���Ե�ֵ��
     * 
     */
    public void setMaxExposureTime(float value) {
        this.maxExposureTime = value;
    }

    /**
     * ��ȡminGain���Ե�ֵ��
     * 
     */
    public float getMinGain() {
        return minGain;
    }

    /**
     * ����minGain���Ե�ֵ��
     * 
     */
    public void setMinGain(float value) {
        this.minGain = value;
    }

    /**
     * ��ȡmaxGain���Ե�ֵ��
     * 
     */
    public float getMaxGain() {
        return maxGain;
    }

    /**
     * ����maxGain���Ե�ֵ��
     * 
     */
    public void setMaxGain(float value) {
        this.maxGain = value;
    }

    /**
     * ��ȡminIris���Ե�ֵ��
     * 
     */
    public float getMinIris() {
        return minIris;
    }

    /**
     * ����minIris���Ե�ֵ��
     * 
     */
    public void setMinIris(float value) {
        this.minIris = value;
    }

    /**
     * ��ȡmaxIris���Ե�ֵ��
     * 
     */
    public float getMaxIris() {
        return maxIris;
    }

    /**
     * ����maxIris���Ե�ֵ��
     * 
     */
    public void setMaxIris(float value) {
        this.maxIris = value;
    }

    /**
     * ��ȡexposureTime���Ե�ֵ��
     * 
     */
    public float getExposureTime() {
        return exposureTime;
    }

    /**
     * ����exposureTime���Ե�ֵ��
     * 
     */
    public void setExposureTime(float value) {
        this.exposureTime = value;
    }

    /**
     * ��ȡgain���Ե�ֵ��
     * 
     */
    public float getGain() {
        return gain;
    }

    /**
     * ����gain���Ե�ֵ��
     * 
     */
    public void setGain(float value) {
        this.gain = value;
    }

    /**
     * ��ȡiris���Ե�ֵ��
     * 
     */
    public float getIris() {
        return iris;
    }

    /**
     * ����iris���Ե�ֵ��
     * 
     */
    public void setIris(float value) {
        this.iris = value;
    }

}
