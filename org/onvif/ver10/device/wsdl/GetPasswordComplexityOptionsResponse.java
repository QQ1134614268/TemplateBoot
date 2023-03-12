
package org.onvif.ver10.device.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.onvif.ver10.schema.IntRange;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MinLenRange" type="{http://www.onvif.org/ver10/schema}IntRange" minOccurs="0"/>
 *         &lt;element name="UppercaseRange" type="{http://www.onvif.org/ver10/schema}IntRange" minOccurs="0"/>
 *         &lt;element name="NumberRange" type="{http://www.onvif.org/ver10/schema}IntRange" minOccurs="0"/>
 *         &lt;element name="SpecialCharsRange" type="{http://www.onvif.org/ver10/schema}IntRange" minOccurs="0"/>
 *         &lt;element name="BlockUsernameOccurrenceSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="PolicyConfigurationLockSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "minLenRange",
    "uppercaseRange",
    "numberRange",
    "specialCharsRange",
    "blockUsernameOccurrenceSupported",
    "policyConfigurationLockSupported"
})
@XmlRootElement(name = "GetPasswordComplexityOptionsResponse")
public class GetPasswordComplexityOptionsResponse {

    @XmlElement(name = "MinLenRange")
    protected IntRange minLenRange;
    @XmlElement(name = "UppercaseRange")
    protected IntRange uppercaseRange;
    @XmlElement(name = "NumberRange")
    protected IntRange numberRange;
    @XmlElement(name = "SpecialCharsRange")
    protected IntRange specialCharsRange;
    @XmlElement(name = "BlockUsernameOccurrenceSupported")
    protected Boolean blockUsernameOccurrenceSupported;
    @XmlElement(name = "PolicyConfigurationLockSupported")
    protected Boolean policyConfigurationLockSupported;

    /**
     * 获取minLenRange属性的值。
     * 
     * @return
     *     possible object is
     *     {@link IntRange }
     *     
     */
    public IntRange getMinLenRange() {
        return minLenRange;
    }

    /**
     * 设置minLenRange属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link IntRange }
     *     
     */
    public void setMinLenRange(IntRange value) {
        this.minLenRange = value;
    }

    /**
     * 获取uppercaseRange属性的值。
     * 
     * @return
     *     possible object is
     *     {@link IntRange }
     *     
     */
    public IntRange getUppercaseRange() {
        return uppercaseRange;
    }

    /**
     * 设置uppercaseRange属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link IntRange }
     *     
     */
    public void setUppercaseRange(IntRange value) {
        this.uppercaseRange = value;
    }

    /**
     * 获取numberRange属性的值。
     * 
     * @return
     *     possible object is
     *     {@link IntRange }
     *     
     */
    public IntRange getNumberRange() {
        return numberRange;
    }

    /**
     * 设置numberRange属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link IntRange }
     *     
     */
    public void setNumberRange(IntRange value) {
        this.numberRange = value;
    }

    /**
     * 获取specialCharsRange属性的值。
     * 
     * @return
     *     possible object is
     *     {@link IntRange }
     *     
     */
    public IntRange getSpecialCharsRange() {
        return specialCharsRange;
    }

    /**
     * 设置specialCharsRange属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link IntRange }
     *     
     */
    public void setSpecialCharsRange(IntRange value) {
        this.specialCharsRange = value;
    }

    /**
     * 获取blockUsernameOccurrenceSupported属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBlockUsernameOccurrenceSupported() {
        return blockUsernameOccurrenceSupported;
    }

    /**
     * 设置blockUsernameOccurrenceSupported属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBlockUsernameOccurrenceSupported(Boolean value) {
        this.blockUsernameOccurrenceSupported = value;
    }

    /**
     * 获取policyConfigurationLockSupported属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPolicyConfigurationLockSupported() {
        return policyConfigurationLockSupported;
    }

    /**
     * 设置policyConfigurationLockSupported属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPolicyConfigurationLockSupported(Boolean value) {
        this.policyConfigurationLockSupported = value;
    }

}
