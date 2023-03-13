
package org.onvif.ver10.device.wsdl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * <p>SystemCapabilities complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="SystemCapabilities">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="DiscoveryResolve" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="DiscoveryBye" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="RemoteDiscovery" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="SystemBackup" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="SystemLogging" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="FirmwareUpgrade" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="HttpFirmwareUpgrade" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="HttpSystemBackup" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="HttpSystemLogging" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="HttpSupportInformation" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="StorageConfiguration" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="MaxStorageConfigurations" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="GeoLocationEntries" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="AutoGeo" type="{http://www.onvif.org/ver10/schema}StringAttrList" />
 *       &lt;attribute name="StorageTypesSupported" type="{http://www.onvif.org/ver10/schema}StringAttrList" />
 *       &lt;attribute name="DiscoveryNotSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="NetworkConfigNotSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="UserConfigNotSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Addons" type="{http://www.onvif.org/ver10/schema}StringAttrList" />
 *       &lt;anyAttribute processContents='lax'/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SystemCapabilities")
public class SystemCapabilities {

    @XmlAttribute(name = "DiscoveryResolve")
    protected Boolean discoveryResolve;
    @XmlAttribute(name = "DiscoveryBye")
    protected Boolean discoveryBye;
    @XmlAttribute(name = "RemoteDiscovery")
    protected Boolean remoteDiscovery;
    @XmlAttribute(name = "SystemBackup")
    protected Boolean systemBackup;
    @XmlAttribute(name = "SystemLogging")
    protected Boolean systemLogging;
    @XmlAttribute(name = "FirmwareUpgrade")
    protected Boolean firmwareUpgrade;
    @XmlAttribute(name = "HttpFirmwareUpgrade")
    protected Boolean httpFirmwareUpgrade;
    @XmlAttribute(name = "HttpSystemBackup")
    protected Boolean httpSystemBackup;
    @XmlAttribute(name = "HttpSystemLogging")
    protected Boolean httpSystemLogging;
    @XmlAttribute(name = "HttpSupportInformation")
    protected Boolean httpSupportInformation;
    @XmlAttribute(name = "StorageConfiguration")
    protected Boolean storageConfiguration;
    @XmlAttribute(name = "MaxStorageConfigurations")
    protected Integer maxStorageConfigurations;
    @XmlAttribute(name = "GeoLocationEntries")
    protected Integer geoLocationEntries;
    @XmlAttribute(name = "AutoGeo")
    protected List<String> autoGeo;
    @XmlAttribute(name = "StorageTypesSupported")
    protected List<String> storageTypesSupported;
    @XmlAttribute(name = "DiscoveryNotSupported")
    protected Boolean discoveryNotSupported;
    @XmlAttribute(name = "NetworkConfigNotSupported")
    protected Boolean networkConfigNotSupported;
    @XmlAttribute(name = "UserConfigNotSupported")
    protected Boolean userConfigNotSupported;
    @XmlAttribute(name = "Addons")
    protected List<String> addons;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * 获取discoveryResolve属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDiscoveryResolve() {
        return discoveryResolve;
    }

    /**
     * 设置discoveryResolve属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDiscoveryResolve(Boolean value) {
        this.discoveryResolve = value;
    }

    /**
     * 获取discoveryBye属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDiscoveryBye() {
        return discoveryBye;
    }

    /**
     * 设置discoveryBye属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDiscoveryBye(Boolean value) {
        this.discoveryBye = value;
    }

    /**
     * 获取remoteDiscovery属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRemoteDiscovery() {
        return remoteDiscovery;
    }

    /**
     * 设置remoteDiscovery属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRemoteDiscovery(Boolean value) {
        this.remoteDiscovery = value;
    }

    /**
     * 获取systemBackup属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSystemBackup() {
        return systemBackup;
    }

    /**
     * 设置systemBackup属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSystemBackup(Boolean value) {
        this.systemBackup = value;
    }

    /**
     * 获取systemLogging属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSystemLogging() {
        return systemLogging;
    }

    /**
     * 设置systemLogging属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSystemLogging(Boolean value) {
        this.systemLogging = value;
    }

    /**
     * 获取firmwareUpgrade属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFirmwareUpgrade() {
        return firmwareUpgrade;
    }

    /**
     * 设置firmwareUpgrade属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFirmwareUpgrade(Boolean value) {
        this.firmwareUpgrade = value;
    }

    /**
     * 获取httpFirmwareUpgrade属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHttpFirmwareUpgrade() {
        return httpFirmwareUpgrade;
    }

    /**
     * 设置httpFirmwareUpgrade属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHttpFirmwareUpgrade(Boolean value) {
        this.httpFirmwareUpgrade = value;
    }

    /**
     * 获取httpSystemBackup属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHttpSystemBackup() {
        return httpSystemBackup;
    }

    /**
     * 设置httpSystemBackup属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHttpSystemBackup(Boolean value) {
        this.httpSystemBackup = value;
    }

    /**
     * 获取httpSystemLogging属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHttpSystemLogging() {
        return httpSystemLogging;
    }

    /**
     * 设置httpSystemLogging属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHttpSystemLogging(Boolean value) {
        this.httpSystemLogging = value;
    }

    /**
     * 获取httpSupportInformation属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHttpSupportInformation() {
        return httpSupportInformation;
    }

    /**
     * 设置httpSupportInformation属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHttpSupportInformation(Boolean value) {
        this.httpSupportInformation = value;
    }

    /**
     * 获取storageConfiguration属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isStorageConfiguration() {
        return storageConfiguration;
    }

    /**
     * 设置storageConfiguration属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setStorageConfiguration(Boolean value) {
        this.storageConfiguration = value;
    }

    /**
     * 获取maxStorageConfigurations属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxStorageConfigurations() {
        return maxStorageConfigurations;
    }

    /**
     * 设置maxStorageConfigurations属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxStorageConfigurations(Integer value) {
        this.maxStorageConfigurations = value;
    }

    /**
     * 获取geoLocationEntries属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getGeoLocationEntries() {
        return geoLocationEntries;
    }

    /**
     * 设置geoLocationEntries属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setGeoLocationEntries(Integer value) {
        this.geoLocationEntries = value;
    }

    /**
     * Gets the value of the autoGeo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the autoGeo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAutoGeo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAutoGeo() {
        if (autoGeo == null) {
            autoGeo = new ArrayList<String>();
        }
        return this.autoGeo;
    }

    /**
     * Gets the value of the storageTypesSupported property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the storageTypesSupported property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStorageTypesSupported().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getStorageTypesSupported() {
        if (storageTypesSupported == null) {
            storageTypesSupported = new ArrayList<String>();
        }
        return this.storageTypesSupported;
    }

    /**
     * 获取discoveryNotSupported属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDiscoveryNotSupported() {
        return discoveryNotSupported;
    }

    /**
     * 设置discoveryNotSupported属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDiscoveryNotSupported(Boolean value) {
        this.discoveryNotSupported = value;
    }

    /**
     * 获取networkConfigNotSupported属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNetworkConfigNotSupported() {
        return networkConfigNotSupported;
    }

    /**
     * 设置networkConfigNotSupported属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNetworkConfigNotSupported(Boolean value) {
        this.networkConfigNotSupported = value;
    }

    /**
     * 获取userConfigNotSupported属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isUserConfigNotSupported() {
        return userConfigNotSupported;
    }

    /**
     * 设置userConfigNotSupported属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUserConfigNotSupported(Boolean value) {
        this.userConfigNotSupported = value;
    }

    /**
     * Gets the value of the addons property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the addons property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAddons().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAddons() {
        if (addons == null) {
            addons = new ArrayList<String>();
        }
        return this.addons;
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
