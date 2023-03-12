
package org.onvif.ver10.device.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
@XmlRootElement(name = "SetPasswordComplexityConfiguration")
public class SetPasswordComplexityConfiguration {

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
     * ��ȡminLen���Ե�ֵ��
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
     * ����minLen���Ե�ֵ��
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
     * ��ȡuppercase���Ե�ֵ��
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
     * ����uppercase���Ե�ֵ��
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
     * ��ȡnumber���Ե�ֵ��
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
     * ����number���Ե�ֵ��
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
     * ��ȡspecialChars���Ե�ֵ��
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
     * ����specialChars���Ե�ֵ��
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
     * ��ȡblockUsernameOccurrence���Ե�ֵ��
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
     * ����blockUsernameOccurrence���Ե�ֵ��
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
     * ��ȡpolicyConfigurationLocked���Ե�ֵ��
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
     * ����policyConfigurationLocked���Ե�ֵ��
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
