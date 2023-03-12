
package org.onvif.ver10.schema;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;


/**
 * <p>CertificateInformation complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="CertificateInformation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CertificateID" type="{http://www.w3.org/2001/XMLSchema}token"/>
 *         &lt;element name="IssuerDN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SubjectDN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="KeyUsage" type="{http://www.onvif.org/ver10/schema}CertificateUsage" minOccurs="0"/>
 *         &lt;element name="ExtendedKeyUsage" type="{http://www.onvif.org/ver10/schema}CertificateUsage" minOccurs="0"/>
 *         &lt;element name="KeyLength" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Version" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SerialNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SignatureAlgorithm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Validity" type="{http://www.onvif.org/ver10/schema}DateTimeRange" minOccurs="0"/>
 *         &lt;element name="Extension" type="{http://www.onvif.org/ver10/schema}CertificateInformationExtension" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;anyAttribute processContents='lax'/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CertificateInformation", propOrder = {
    "certificateID",
    "issuerDN",
    "subjectDN",
    "keyUsage",
    "extendedKeyUsage",
    "keyLength",
    "version",
    "serialNum",
    "signatureAlgorithm",
    "validity",
    "extension"
})
public class CertificateInformation {

    @XmlElement(name = "CertificateID", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String certificateID;
    @XmlElement(name = "IssuerDN")
    protected String issuerDN;
    @XmlElement(name = "SubjectDN")
    protected String subjectDN;
    @XmlElement(name = "KeyUsage")
    protected CertificateUsage keyUsage;
    @XmlElement(name = "ExtendedKeyUsage")
    protected CertificateUsage extendedKeyUsage;
    @XmlElement(name = "KeyLength")
    protected Integer keyLength;
    @XmlElement(name = "Version")
    protected String version;
    @XmlElement(name = "SerialNum")
    protected String serialNum;
    @XmlElement(name = "SignatureAlgorithm")
    protected String signatureAlgorithm;
    @XmlElement(name = "Validity")
    protected DateTimeRange validity;
    @XmlElement(name = "Extension")
    protected CertificateInformationExtension extension;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * ��ȡcertificateID���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCertificateID() {
        return certificateID;
    }

    /**
     * ����certificateID���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCertificateID(String value) {
        this.certificateID = value;
    }

    /**
     * ��ȡissuerDN���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssuerDN() {
        return issuerDN;
    }

    /**
     * ����issuerDN���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssuerDN(String value) {
        this.issuerDN = value;
    }

    /**
     * ��ȡsubjectDN���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubjectDN() {
        return subjectDN;
    }

    /**
     * ����subjectDN���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubjectDN(String value) {
        this.subjectDN = value;
    }

    /**
     * ��ȡkeyUsage���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CertificateUsage }
     *     
     */
    public CertificateUsage getKeyUsage() {
        return keyUsage;
    }

    /**
     * ����keyUsage���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CertificateUsage }
     *     
     */
    public void setKeyUsage(CertificateUsage value) {
        this.keyUsage = value;
    }

    /**
     * ��ȡextendedKeyUsage���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CertificateUsage }
     *     
     */
    public CertificateUsage getExtendedKeyUsage() {
        return extendedKeyUsage;
    }

    /**
     * ����extendedKeyUsage���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CertificateUsage }
     *     
     */
    public void setExtendedKeyUsage(CertificateUsage value) {
        this.extendedKeyUsage = value;
    }

    /**
     * ��ȡkeyLength���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getKeyLength() {
        return keyLength;
    }

    /**
     * ����keyLength���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setKeyLength(Integer value) {
        this.keyLength = value;
    }

    /**
     * ��ȡversion���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * ����version���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * ��ȡserialNum���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSerialNum() {
        return serialNum;
    }

    /**
     * ����serialNum���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSerialNum(String value) {
        this.serialNum = value;
    }

    /**
     * ��ȡsignatureAlgorithm���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignatureAlgorithm() {
        return signatureAlgorithm;
    }

    /**
     * ����signatureAlgorithm���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignatureAlgorithm(String value) {
        this.signatureAlgorithm = value;
    }

    /**
     * ��ȡvalidity���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link DateTimeRange }
     *     
     */
    public DateTimeRange getValidity() {
        return validity;
    }

    /**
     * ����validity���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link DateTimeRange }
     *     
     */
    public void setValidity(DateTimeRange value) {
        this.validity = value;
    }

    /**
     * ��ȡextension���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CertificateInformationExtension }
     *     
     */
    public CertificateInformationExtension getExtension() {
        return extension;
    }

    /**
     * ����extension���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CertificateInformationExtension }
     *     
     */
    public void setExtension(CertificateInformationExtension value) {
        this.extension = value;
    }

    /**
     * Gets a map that contains attributes that aren't bound to any typed property on this class.
     * 
     * <p>
     * the map is keyed by the name of the attribute and 
     * the value is the string value of the attribute.
     * 
     * the map returned by this method is live, and you can add new attribute
     * by updating the map directly. Because of this design, there's no setter.
     * 
     * 
     * @return
     *     always non-null
     */
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

}
