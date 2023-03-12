
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
 * <p>PresetTour complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="PresetTour">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.onvif.org/ver10/schema}Name" minOccurs="0"/>
 *         &lt;element name="Status" type="{http://www.onvif.org/ver10/schema}PTZPresetTourStatus"/>
 *         &lt;element name="AutoStart" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="StartingCondition" type="{http://www.onvif.org/ver10/schema}PTZPresetTourStartingCondition"/>
 *         &lt;element name="TourSpot" type="{http://www.onvif.org/ver10/schema}PTZPresetTourSpot" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Extension" type="{http://www.onvif.org/ver10/schema}PTZPresetTourExtension" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="token" type="{http://www.onvif.org/ver10/schema}ReferenceToken" />
 *       &lt;anyAttribute processContents='lax'/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PresetTour", propOrder = {
    "name",
    "status",
    "autoStart",
    "startingCondition",
    "tourSpot",
    "extension"
})
public class PresetTour {

    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Status", required = true)
    protected PTZPresetTourStatus status;
    @XmlElement(name = "AutoStart")
    protected boolean autoStart;
    @XmlElement(name = "StartingCondition", required = true)
    protected PTZPresetTourStartingCondition startingCondition;
    @XmlElement(name = "TourSpot")
    protected List<PTZPresetTourSpot> tourSpot;
    @XmlElement(name = "Extension")
    protected PTZPresetTourExtension extension;
    @XmlAttribute(name = "token")
    protected String token;
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
     * ��ȡstatus���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link PTZPresetTourStatus }
     *     
     */
    public PTZPresetTourStatus getStatus() {
        return status;
    }

    /**
     * ����status���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link PTZPresetTourStatus }
     *     
     */
    public void setStatus(PTZPresetTourStatus value) {
        this.status = value;
    }

    /**
     * ��ȡautoStart���Ե�ֵ��
     * 
     */
    public boolean isAutoStart() {
        return autoStart;
    }

    /**
     * ����autoStart���Ե�ֵ��
     * 
     */
    public void setAutoStart(boolean value) {
        this.autoStart = value;
    }

    /**
     * ��ȡstartingCondition���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link PTZPresetTourStartingCondition }
     *     
     */
    public PTZPresetTourStartingCondition getStartingCondition() {
        return startingCondition;
    }

    /**
     * ����startingCondition���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link PTZPresetTourStartingCondition }
     *     
     */
    public void setStartingCondition(PTZPresetTourStartingCondition value) {
        this.startingCondition = value;
    }

    /**
     * Gets the value of the tourSpot property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tourSpot property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTourSpot().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PTZPresetTourSpot }
     * 
     * 
     */
    public List<PTZPresetTourSpot> getTourSpot() {
        if (tourSpot == null) {
            tourSpot = new ArrayList<PTZPresetTourSpot>();
        }
        return this.tourSpot;
    }

    /**
     * ��ȡextension���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link PTZPresetTourExtension }
     *     
     */
    public PTZPresetTourExtension getExtension() {
        return extension;
    }

    /**
     * ����extension���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link PTZPresetTourExtension }
     *     
     */
    public void setExtension(PTZPresetTourExtension value) {
        this.extension = value;
    }

    /**
     * ��ȡtoken���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToken() {
        return token;
    }

    /**
     * ����token���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToken(String value) {
        this.token = value;
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
