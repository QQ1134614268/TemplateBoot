
package org.onvif.ver10.schema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * <p>PTZNode complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="PTZNode">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.onvif.org/ver10/schema}DeviceEntity">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.onvif.org/ver10/schema}Name" minOccurs="0"/>
 *         &lt;element name="SupportedPTZSpaces" type="{http://www.onvif.org/ver10/schema}PTZSpaces"/>
 *         &lt;element name="MaximumNumberOfPresets" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="HomeSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="AuxiliaryCommands" type="{http://www.onvif.org/ver10/schema}AuxiliaryData" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Extension" type="{http://www.onvif.org/ver10/schema}PTZNodeExtension" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="FixedHomePosition" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="GeoMove" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;anyAttribute processContents='lax'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PTZNode", propOrder = {
    "name",
    "supportedPTZSpaces",
    "maximumNumberOfPresets",
    "homeSupported",
    "auxiliaryCommands",
    "extension"
})
public class PTZNode
    extends DeviceEntity
{

    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "SupportedPTZSpaces", required = true)
    protected PTZSpaces supportedPTZSpaces;
    @XmlElement(name = "MaximumNumberOfPresets")
    protected int maximumNumberOfPresets;
    @XmlElement(name = "HomeSupported")
    protected boolean homeSupported;
    @XmlElement(name = "AuxiliaryCommands")
    protected List<String> auxiliaryCommands;
    @XmlElement(name = "Extension")
    protected PTZNodeExtension extension;
    @XmlAttribute(name = "FixedHomePosition")
    protected Boolean fixedHomePosition;
    @XmlAttribute(name = "GeoMove")
    protected Boolean geoMove;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * ��ȡname���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * ����name���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * ��ȡsupportedPTZSpaces���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link PTZSpaces }
     *     
     */
    public PTZSpaces getSupportedPTZSpaces() {
        return supportedPTZSpaces;
    }

    /**
     * ����supportedPTZSpaces���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link PTZSpaces }
     *     
     */
    public void setSupportedPTZSpaces(PTZSpaces value) {
        this.supportedPTZSpaces = value;
    }

    /**
     * ��ȡmaximumNumberOfPresets���Ե�ֵ��
     * 
     */
    public int getMaximumNumberOfPresets() {
        return maximumNumberOfPresets;
    }

    /**
     * ����maximumNumberOfPresets���Ե�ֵ��
     * 
     */
    public void setMaximumNumberOfPresets(int value) {
        this.maximumNumberOfPresets = value;
    }

    /**
     * ��ȡhomeSupported���Ե�ֵ��
     * 
     */
    public boolean isHomeSupported() {
        return homeSupported;
    }

    /**
     * ����homeSupported���Ե�ֵ��
     * 
     */
    public void setHomeSupported(boolean value) {
        this.homeSupported = value;
    }

    /**
     * Gets the value of the auxiliaryCommands property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the auxiliaryCommands property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAuxiliaryCommands().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAuxiliaryCommands() {
        if (auxiliaryCommands == null) {
            auxiliaryCommands = new ArrayList<String>();
        }
        return this.auxiliaryCommands;
    }

    /**
     * ��ȡextension���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link PTZNodeExtension }
     *     
     */
    public PTZNodeExtension getExtension() {
        return extension;
    }

    /**
     * ����extension���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link PTZNodeExtension }
     *     
     */
    public void setExtension(PTZNodeExtension value) {
        this.extension = value;
    }

    /**
     * ��ȡfixedHomePosition���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFixedHomePosition() {
        return fixedHomePosition;
    }

    /**
     * ����fixedHomePosition���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFixedHomePosition(Boolean value) {
        this.fixedHomePosition = value;
    }

    /**
     * ��ȡgeoMove���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isGeoMove() {
        return geoMove;
    }

    /**
     * ����geoMove���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setGeoMove(Boolean value) {
        this.geoMove = value;
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
