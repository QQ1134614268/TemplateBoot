
package org.onvif.ver10.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>WhiteBalanceOptions20 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="WhiteBalanceOptions20">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Mode" type="{http://www.onvif.org/ver10/schema}WhiteBalanceMode" maxOccurs="unbounded"/>
 *         &lt;element name="YrGain" type="{http://www.onvif.org/ver10/schema}FloatRange" minOccurs="0"/>
 *         &lt;element name="YbGain" type="{http://www.onvif.org/ver10/schema}FloatRange" minOccurs="0"/>
 *         &lt;element name="Extension" type="{http://www.onvif.org/ver10/schema}WhiteBalanceOptions20Extension" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WhiteBalanceOptions20", propOrder = {
    "mode",
    "yrGain",
    "ybGain",
    "extension"
})
public class WhiteBalanceOptions20 {

    @XmlElement(name = "Mode", required = true)
    @XmlSchemaType(name = "string")
    protected List<WhiteBalanceMode> mode;
    @XmlElement(name = "YrGain")
    protected FloatRange yrGain;
    @XmlElement(name = "YbGain")
    protected FloatRange ybGain;
    @XmlElement(name = "Extension")
    protected WhiteBalanceOptions20Extension extension;

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
     * {@link WhiteBalanceMode }
     * 
     * 
     */
    public List<WhiteBalanceMode> getMode() {
        if (mode == null) {
            mode = new ArrayList<WhiteBalanceMode>();
        }
        return this.mode;
    }

    /**
     * ��ȡyrGain���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link FloatRange }
     *     
     */
    public FloatRange getYrGain() {
        return yrGain;
    }

    /**
     * ����yrGain���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link FloatRange }
     *     
     */
    public void setYrGain(FloatRange value) {
        this.yrGain = value;
    }

    /**
     * ��ȡybGain���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link FloatRange }
     *     
     */
    public FloatRange getYbGain() {
        return ybGain;
    }

    /**
     * ����ybGain���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link FloatRange }
     *     
     */
    public void setYbGain(FloatRange value) {
        this.ybGain = value;
    }

    /**
     * ��ȡextension���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link WhiteBalanceOptions20Extension }
     *     
     */
    public WhiteBalanceOptions20Extension getExtension() {
        return extension;
    }

    /**
     * ����extension���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link WhiteBalanceOptions20Extension }
     *     
     */
    public void setExtension(WhiteBalanceOptions20Extension value) {
        this.extension = value;
    }

}
