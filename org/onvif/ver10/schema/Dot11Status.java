
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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;
import org.w3c.dom.Element;


/**
 * <p>Dot11Status complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="Dot11Status">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SSID" type="{http://www.onvif.org/ver10/schema}Dot11SSIDType"/>
 *         &lt;element name="BSSID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PairCipher" type="{http://www.onvif.org/ver10/schema}Dot11Cipher" minOccurs="0"/>
 *         &lt;element name="GroupCipher" type="{http://www.onvif.org/ver10/schema}Dot11Cipher" minOccurs="0"/>
 *         &lt;element name="SignalStrength" type="{http://www.onvif.org/ver10/schema}Dot11SignalStrength" minOccurs="0"/>
 *         &lt;element name="ActiveConfigAlias" type="{http://www.onvif.org/ver10/schema}ReferenceToken"/>
 *         &lt;any processContents='lax' maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "Dot11Status", propOrder = {
    "ssid",
    "bssid",
    "pairCipher",
    "groupCipher",
    "signalStrength",
    "activeConfigAlias",
    "any"
})
public class Dot11Status {

    @XmlElement(name = "SSID", required = true, type = String.class)
    @XmlJavaTypeAdapter(HexBinaryAdapter.class)
    @XmlSchemaType(name = "hexBinary")
    protected byte[] ssid;
    @XmlElement(name = "BSSID")
    protected String bssid;
    @XmlElement(name = "PairCipher")
    @XmlSchemaType(name = "string")
    protected Dot11Cipher pairCipher;
    @XmlElement(name = "GroupCipher")
    @XmlSchemaType(name = "string")
    protected Dot11Cipher groupCipher;
    @XmlElement(name = "SignalStrength")
    @XmlSchemaType(name = "string")
    protected Dot11SignalStrength signalStrength;
    @XmlElement(name = "ActiveConfigAlias", required = true)
    protected String activeConfigAlias;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * ��ȡssid���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public byte[] getSSID() {
        return ssid;
    }

    /**
     * ����ssid���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSSID(byte[] value) {
        this.ssid = value;
    }

    /**
     * ��ȡbssid���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBSSID() {
        return bssid;
    }

    /**
     * ����bssid���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBSSID(String value) {
        this.bssid = value;
    }

    /**
     * ��ȡpairCipher���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Dot11Cipher }
     *     
     */
    public Dot11Cipher getPairCipher() {
        return pairCipher;
    }

    /**
     * ����pairCipher���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Dot11Cipher }
     *     
     */
    public void setPairCipher(Dot11Cipher value) {
        this.pairCipher = value;
    }

    /**
     * ��ȡgroupCipher���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Dot11Cipher }
     *     
     */
    public Dot11Cipher getGroupCipher() {
        return groupCipher;
    }

    /**
     * ����groupCipher���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Dot11Cipher }
     *     
     */
    public void setGroupCipher(Dot11Cipher value) {
        this.groupCipher = value;
    }

    /**
     * ��ȡsignalStrength���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Dot11SignalStrength }
     *     
     */
    public Dot11SignalStrength getSignalStrength() {
        return signalStrength;
    }

    /**
     * ����signalStrength���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Dot11SignalStrength }
     *     
     */
    public void setSignalStrength(Dot11SignalStrength value) {
        this.signalStrength = value;
    }

    /**
     * ��ȡactiveConfigAlias���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActiveConfigAlias() {
        return activeConfigAlias;
    }

    /**
     * ����activeConfigAlias���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActiveConfigAlias(String value) {
        this.activeConfigAlias = value;
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
