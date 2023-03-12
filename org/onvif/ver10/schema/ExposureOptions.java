
package org.onvif.ver10.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ExposureOptions complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ExposureOptions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Mode" type="{http://www.onvif.org/ver10/schema}ExposureMode" maxOccurs="unbounded"/>
 *         &lt;element name="Priority" type="{http://www.onvif.org/ver10/schema}ExposurePriority" maxOccurs="unbounded"/>
 *         &lt;element name="MinExposureTime" type="{http://www.onvif.org/ver10/schema}FloatRange"/>
 *         &lt;element name="MaxExposureTime" type="{http://www.onvif.org/ver10/schema}FloatRange"/>
 *         &lt;element name="MinGain" type="{http://www.onvif.org/ver10/schema}FloatRange"/>
 *         &lt;element name="MaxGain" type="{http://www.onvif.org/ver10/schema}FloatRange"/>
 *         &lt;element name="MinIris" type="{http://www.onvif.org/ver10/schema}FloatRange"/>
 *         &lt;element name="MaxIris" type="{http://www.onvif.org/ver10/schema}FloatRange"/>
 *         &lt;element name="ExposureTime" type="{http://www.onvif.org/ver10/schema}FloatRange"/>
 *         &lt;element name="Gain" type="{http://www.onvif.org/ver10/schema}FloatRange"/>
 *         &lt;element name="Iris" type="{http://www.onvif.org/ver10/schema}FloatRange"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExposureOptions", propOrder = {
    "mode",
    "priority",
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
public class ExposureOptions {

    @XmlElement(name = "Mode", required = true)
    @XmlSchemaType(name = "string")
    protected List<ExposureMode> mode;
    @XmlElement(name = "Priority", required = true)
    @XmlSchemaType(name = "string")
    protected List<ExposurePriority> priority;
    @XmlElement(name = "MinExposureTime", required = true)
    protected FloatRange minExposureTime;
    @XmlElement(name = "MaxExposureTime", required = true)
    protected FloatRange maxExposureTime;
    @XmlElement(name = "MinGain", required = true)
    protected FloatRange minGain;
    @XmlElement(name = "MaxGain", required = true)
    protected FloatRange maxGain;
    @XmlElement(name = "MinIris", required = true)
    protected FloatRange minIris;
    @XmlElement(name = "MaxIris", required = true)
    protected FloatRange maxIris;
    @XmlElement(name = "ExposureTime", required = true)
    protected FloatRange exposureTime;
    @XmlElement(name = "Gain", required = true)
    protected FloatRange gain;
    @XmlElement(name = "Iris", required = true)
    protected FloatRange iris;

    /**
     * Gets the value of the mode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExposureMode }
     * 
     * 
     */
    public List<ExposureMode> getMode() {
        if (mode == null) {
            mode = new ArrayList<ExposureMode>();
        }
        return this.mode;
    }

    /**
     * Gets the value of the priority property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the priority property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPriority().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExposurePriority }
     * 
     * 
     */
    public List<ExposurePriority> getPriority() {
        if (priority == null) {
            priority = new ArrayList<ExposurePriority>();
        }
        return this.priority;
    }

    /**
     * ��ȡminExposureTime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link FloatRange }
     *     
     */
    public FloatRange getMinExposureTime() {
        return minExposureTime;
    }

    /**
     * ����minExposureTime���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link FloatRange }
     *     
     */
    public void setMinExposureTime(FloatRange value) {
        this.minExposureTime = value;
    }

    /**
     * ��ȡmaxExposureTime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link FloatRange }
     *     
     */
    public FloatRange getMaxExposureTime() {
        return maxExposureTime;
    }

    /**
     * ����maxExposureTime���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link FloatRange }
     *     
     */
    public void setMaxExposureTime(FloatRange value) {
        this.maxExposureTime = value;
    }

    /**
     * ��ȡminGain���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link FloatRange }
     *     
     */
    public FloatRange getMinGain() {
        return minGain;
    }

    /**
     * ����minGain���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link FloatRange }
     *     
     */
    public void setMinGain(FloatRange value) {
        this.minGain = value;
    }

    /**
     * ��ȡmaxGain���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link FloatRange }
     *     
     */
    public FloatRange getMaxGain() {
        return maxGain;
    }

    /**
     * ����maxGain���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link FloatRange }
     *     
     */
    public void setMaxGain(FloatRange value) {
        this.maxGain = value;
    }

    /**
     * ��ȡminIris���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link FloatRange }
     *     
     */
    public FloatRange getMinIris() {
        return minIris;
    }

    /**
     * ����minIris���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link FloatRange }
     *     
     */
    public void setMinIris(FloatRange value) {
        this.minIris = value;
    }

    /**
     * ��ȡmaxIris���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link FloatRange }
     *     
     */
    public FloatRange getMaxIris() {
        return maxIris;
    }

    /**
     * ����maxIris���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link FloatRange }
     *     
     */
    public void setMaxIris(FloatRange value) {
        this.maxIris = value;
    }

    /**
     * ��ȡexposureTime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link FloatRange }
     *     
     */
    public FloatRange getExposureTime() {
        return exposureTime;
    }

    /**
     * ����exposureTime���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link FloatRange }
     *     
     */
    public void setExposureTime(FloatRange value) {
        this.exposureTime = value;
    }

    /**
     * ��ȡgain���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link FloatRange }
     *     
     */
    public FloatRange getGain() {
        return gain;
    }

    /**
     * ����gain���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link FloatRange }
     *     
     */
    public void setGain(FloatRange value) {
        this.gain = value;
    }

    /**
     * ��ȡiris���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link FloatRange }
     *     
     */
    public FloatRange getIris() {
        return iris;
    }

    /**
     * ����iris���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link FloatRange }
     *     
     */
    public void setIris(FloatRange value) {
        this.iris = value;
    }

}
