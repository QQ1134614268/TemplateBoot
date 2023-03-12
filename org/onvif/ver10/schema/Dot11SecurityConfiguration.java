
package org.onvif.ver10.schema;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * <p>Dot11SecurityConfiguration complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="Dot11SecurityConfiguration">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Mode" type="{http://www.onvif.org/ver10/schema}Dot11SecurityMode"/>
 *         &lt;element name="Algorithm" type="{http://www.onvif.org/ver10/schema}Dot11Cipher" minOccurs="0"/>
 *         &lt;element name="PSK" type="{http://www.onvif.org/ver10/schema}Dot11PSKSet" minOccurs="0"/>
 *         &lt;element name="Dot1X" type="{http://www.onvif.org/ver10/schema}ReferenceToken" minOccurs="0"/>
 *         &lt;element name="Extension" type="{http://www.onvif.org/ver10/schema}Dot11SecurityConfigurationExtension" minOccurs="0"/>
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
@XmlType(name = "Dot11SecurityConfiguration", propOrder = {
    "mode",
    "algorithm",
    "psk",
    "dot1X",
    "extension"
})
public class Dot11SecurityConfiguration {

    @XmlElement(name = "Mode", required = true)
    @XmlSchemaType(name = "string")
    protected Dot11SecurityMode mode;
    @XmlElement(name = "Algorithm")
    @XmlSchemaType(name = "string")
    protected Dot11Cipher algorithm;
    @XmlElement(name = "PSK")
    protected Dot11PSKSet psk;
    @XmlElement(name = "Dot1X")
    protected String dot1X;
    @XmlElement(name = "Extension")
    protected Dot11SecurityConfigurationExtension extension;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * ��ȡmode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Dot11SecurityMode }
     *     
     */
    public Dot11SecurityMode getMode() {
        return mode;
    }

    /**
     * ����mode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Dot11SecurityMode }
     *     
     */
    public void setMode(Dot11SecurityMode value) {
        this.mode = value;
    }

    /**
     * ��ȡalgorithm���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Dot11Cipher }
     *     
     */
    public Dot11Cipher getAlgorithm() {
        return algorithm;
    }

    /**
     * ����algorithm���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Dot11Cipher }
     *     
     */
    public void setAlgorithm(Dot11Cipher value) {
        this.algorithm = value;
    }

    /**
     * ��ȡpsk���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Dot11PSKSet }
     *     
     */
    public Dot11PSKSet getPSK() {
        return psk;
    }

    /**
     * ����psk���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Dot11PSKSet }
     *     
     */
    public void setPSK(Dot11PSKSet value) {
        this.psk = value;
    }

    /**
     * ��ȡdot1X���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDot1X() {
        return dot1X;
    }

    /**
     * ����dot1X���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDot1X(String value) {
        this.dot1X = value;
    }

    /**
     * ��ȡextension���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Dot11SecurityConfigurationExtension }
     *     
     */
    public Dot11SecurityConfigurationExtension getExtension() {
        return extension;
    }

    /**
     * ����extension���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Dot11SecurityConfigurationExtension }
     *     
     */
    public void setExtension(Dot11SecurityConfigurationExtension value) {
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
