
package com.it.webservice.onvif.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>OnvifVersion complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="OnvifVersion"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Major" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="Minor" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OnvifVersion", propOrder = {
    "major",
    "minor"
})
public class OnvifVersion {

    @XmlElement(name = "Major")
    protected int major;
    @XmlElement(name = "Minor")
    protected int minor;

    /**
     * 获取major属性的值。
     * 
     */
    public int getMajor() {
        return major;
    }

    /**
     * 设置major属性的值。
     * 
     */
    public void setMajor(int value) {
        this.major = value;
    }

    /**
     * 获取minor属性的值。
     * 
     */
    public int getMinor() {
        return minor;
    }

    /**
     * 设置minor属性的值。
     * 
     */
    public void setMinor(int value) {
        this.minor = value;
    }

}
