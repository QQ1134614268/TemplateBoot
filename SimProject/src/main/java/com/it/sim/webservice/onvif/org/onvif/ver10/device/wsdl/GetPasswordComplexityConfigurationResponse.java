
package org.onvif.ver10.device.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="MinLen" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Uppercase" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Number" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="SpecialChars" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="BlockUsernameOccurrence" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="PolicyConfigurationLocked" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
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
    "minLen",
    "uppercase",
    "number",
    "specialChars",
    "blockUsernameOccurrence",
    "policyConfigurationLocked"
})
@XmlRootElement(name = "GetPasswordComplexityConfigurationResponse")
public class GetPasswordComplexityConfigurationResponse {

    @XmlElement(name = "MinLen")
    protected Integer minLen;
    @XmlElement(name = "Uppercase")
    protected Integer uppercase;
    @XmlElement(name = "Number")
    protected Integer number;
    @XmlElement(name = "SpecialChars")
    protected Integer specialChars;
    @XmlElement(name = "BlockUsernameOccurrence")
    protected Boolean blockUsernameOccurrence;
    @XmlElement(name = "PolicyConfigurationLocked")
    protected Boolean policyConfigurationLocked;

    /**
     * 获取minLen属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMinLen() {
        return minLen;
    }

    /**
     * 设置minLen属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMinLen(Integer value) {
        this.minLen = value;
    }

    /**
     * 获取uppercase属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getUppercase() {
        return uppercase;
    }

    /**
     * 设置uppercase属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setUppercase(Integer value) {
        this.uppercase = value;
    }

    /**
     * 获取number属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * 设置number属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumber(Integer value) {
        this.number = value;
    }

    /**
     * 获取specialChars属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSpecialChars() {
        return specialChars;
    }

    /**
     * 设置specialChars属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSpecialChars(Integer value) {
        this.specialChars = value;
    }

    /**
     * 获取blockUsernameOccurrence属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBlockUsernameOccurrence() {
        return blockUsernameOccurrence;
    }

    /**
     * 设置blockUsernameOccurrence属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBlockUsernameOccurrence(Boolean value) {
        this.blockUsernameOccurrence = value;
    }

    /**
     * 获取policyConfigurationLocked属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPolicyConfigurationLocked() {
        return policyConfigurationLocked;
    }

    /**
     * 设置policyConfigurationLocked属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPolicyConfigurationLocked(Boolean value) {
        this.policyConfigurationLocked = value;
    }

}
