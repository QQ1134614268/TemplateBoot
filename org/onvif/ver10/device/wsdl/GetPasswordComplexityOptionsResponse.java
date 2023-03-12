
package org.onvif.ver10.device.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.onvif.ver10.schema.IntRange;


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
     * ��ȡminLenRange���Ե�ֵ��
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
     * ����minLenRange���Ե�ֵ��
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
     * ��ȡuppercaseRange���Ե�ֵ��
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
     * ����uppercaseRange���Ե�ֵ��
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
     * ��ȡnumberRange���Ե�ֵ��
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
     * ����numberRange���Ե�ֵ��
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
     * ��ȡspecialCharsRange���Ե�ֵ��
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
     * ����specialCharsRange���Ե�ֵ��
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
     * ��ȡblockUsernameOccurrenceSupported���Ե�ֵ��
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
     * ����blockUsernameOccurrenceSupported���Ե�ֵ��
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
     * ��ȡpolicyConfigurationLockSupported���Ե�ֵ��
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
     * ����policyConfigurationLockSupported���Ե�ֵ��
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
