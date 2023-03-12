
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
 * <p>Dot11Capabilities complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="Dot11Capabilities">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TKIP" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ScanAvailableNetworks" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="MultipleConfiguration" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="AdHocStationMode" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="WEP" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
@XmlType(name = "Dot11Capabilities", propOrder = {
    "tkip",
    "scanAvailableNetworks",
    "multipleConfiguration",
    "adHocStationMode",
    "wep",
    "any"
})
public class Dot11Capabilities {

    @XmlElement(name = "TKIP")
    protected boolean tkip;
    @XmlElement(name = "ScanAvailableNetworks")
    protected boolean scanAvailableNetworks;
    @XmlElement(name = "MultipleConfiguration")
    protected boolean multipleConfiguration;
    @XmlElement(name = "AdHocStationMode")
    protected boolean adHocStationMode;
    @XmlElement(name = "WEP")
    protected boolean wep;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * ��ȡtkip���Ե�ֵ��
     * 
     */
    public boolean isTKIP() {
        return tkip;
    }

    /**
     * ����tkip���Ե�ֵ��
     * 
     */
    public void setTKIP(boolean value) {
        this.tkip = value;
    }

    /**
     * ��ȡscanAvailableNetworks���Ե�ֵ��
     * 
     */
    public boolean isScanAvailableNetworks() {
        return scanAvailableNetworks;
    }

    /**
     * ����scanAvailableNetworks���Ե�ֵ��
     * 
     */
    public void setScanAvailableNetworks(boolean value) {
        this.scanAvailableNetworks = value;
    }

    /**
     * ��ȡmultipleConfiguration���Ե�ֵ��
     * 
     */
    public boolean isMultipleConfiguration() {
        return multipleConfiguration;
    }

    /**
     * ����multipleConfiguration���Ե�ֵ��
     * 
     */
    public void setMultipleConfiguration(boolean value) {
        this.multipleConfiguration = value;
    }

    /**
     * ��ȡadHocStationMode���Ե�ֵ��
     * 
     */
    public boolean isAdHocStationMode() {
        return adHocStationMode;
    }

    /**
     * ����adHocStationMode���Ե�ֵ��
     * 
     */
    public void setAdHocStationMode(boolean value) {
        this.adHocStationMode = value;
    }

    /**
     * ��ȡwep���Ե�ֵ��
     * 
     */
    public boolean isWEP() {
        return wep;
    }

    /**
     * ����wep���Ե�ֵ��
     * 
     */
    public void setWEP(boolean value) {
        this.wep = value;
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
