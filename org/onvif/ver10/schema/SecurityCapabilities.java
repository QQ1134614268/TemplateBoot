
package org.onvif.ver10.schema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import org.w3c.dom.Element;


/**
 * <p>SecurityCapabilities complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="SecurityCapabilities">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TLS1.1" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="TLS1.2" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="OnboardKeyGeneration" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="AccessPolicyConfig" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="X.509Token" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="SAMLToken" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="KerberosToken" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="RELToken" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Extension" type="{http://www.onvif.org/ver10/schema}SecurityCapabilitiesExtension" minOccurs="0"/>
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
@XmlType(name = "SecurityCapabilities", propOrder = {
    "tls11",
    "tls12",
    "onboardKeyGeneration",
    "accessPolicyConfig",
    "x509Token",
    "samlToken",
    "kerberosToken",
    "relToken",
    "any",
    "extension"
})
public class SecurityCapabilities {

    @XmlElement(name = "TLS1.1")
    protected boolean tls11;
    @XmlElement(name = "TLS1.2")
    protected boolean tls12;
    @XmlElement(name = "OnboardKeyGeneration")
    protected boolean onboardKeyGeneration;
    @XmlElement(name = "AccessPolicyConfig")
    protected boolean accessPolicyConfig;
    @XmlElement(name = "X.509Token")
    protected boolean x509Token;
    @XmlElement(name = "SAMLToken")
    protected boolean samlToken;
    @XmlElement(name = "KerberosToken")
    protected boolean kerberosToken;
    @XmlElement(name = "RELToken")
    protected boolean relToken;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlElement(name = "Extension")
    protected SecurityCapabilitiesExtension extension;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * ��ȡtls11���Ե�ֵ��
     * 
     */
    public boolean isTLS11() {
        return tls11;
    }

    /**
     * ����tls11���Ե�ֵ��
     * 
     */
    public void setTLS11(boolean value) {
        this.tls11 = value;
    }

    /**
     * ��ȡtls12���Ե�ֵ��
     * 
     */
    public boolean isTLS12() {
        return tls12;
    }

    /**
     * ����tls12���Ե�ֵ��
     * 
     */
    public void setTLS12(boolean value) {
        this.tls12 = value;
    }

    /**
     * ��ȡonboardKeyGeneration���Ե�ֵ��
     * 
     */
    public boolean isOnboardKeyGeneration() {
        return onboardKeyGeneration;
    }

    /**
     * ����onboardKeyGeneration���Ե�ֵ��
     * 
     */
    public void setOnboardKeyGeneration(boolean value) {
        this.onboardKeyGeneration = value;
    }

    /**
     * ��ȡaccessPolicyConfig���Ե�ֵ��
     * 
     */
    public boolean isAccessPolicyConfig() {
        return accessPolicyConfig;
    }

    /**
     * ����accessPolicyConfig���Ե�ֵ��
     * 
     */
    public void setAccessPolicyConfig(boolean value) {
        this.accessPolicyConfig = value;
    }

    /**
     * ��ȡx509Token���Ե�ֵ��
     * 
     */
    public boolean isX509Token() {
        return x509Token;
    }

    /**
     * ����x509Token���Ե�ֵ��
     * 
     */
    public void setX509Token(boolean value) {
        this.x509Token = value;
    }

    /**
     * ��ȡsamlToken���Ե�ֵ��
     * 
     */
    public boolean isSAMLToken() {
        return samlToken;
    }

    /**
     * ����samlToken���Ե�ֵ��
     * 
     */
    public void setSAMLToken(boolean value) {
        this.samlToken = value;
    }

    /**
     * ��ȡkerberosToken���Ե�ֵ��
     * 
     */
    public boolean isKerberosToken() {
        return kerberosToken;
    }

    /**
     * ����kerberosToken���Ե�ֵ��
     * 
     */
    public void setKerberosToken(boolean value) {
        this.kerberosToken = value;
    }

    /**
     * ��ȡrelToken���Ե�ֵ��
     * 
     */
    public boolean isRELToken() {
        return relToken;
    }

    /**
     * ����relToken���Ե�ֵ��
     * 
     */
    public void setRELToken(boolean value) {
        this.relToken = value;
    }

    /**
     * Gets the value of the any property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the any property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAny().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Element }
     * {@link Object }
     * 
     * 
     */
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }

    /**
     * ��ȡextension���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link SecurityCapabilitiesExtension }
     *     
     */
    public SecurityCapabilitiesExtension getExtension() {
        return extension;
    }

    /**
     * ����extension���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link SecurityCapabilitiesExtension }
     *     
     */
    public void setExtension(SecurityCapabilitiesExtension value) {
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
