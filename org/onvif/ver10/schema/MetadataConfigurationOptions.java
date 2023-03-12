
package org.onvif.ver10.schema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import org.w3c.dom.Element;


/**
 * <p>MetadataConfigurationOptions complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="MetadataConfigurationOptions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PTZStatusFilterOptions" type="{http://www.onvif.org/ver10/schema}PTZStatusFilterOptions"/>
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Extension" type="{http://www.onvif.org/ver10/schema}MetadataConfigurationOptionsExtension" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="GeoLocation" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="MaxContentFilterSize" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;anyAttribute processContents='lax'/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MetadataConfigurationOptions", propOrder = {
    "ptzStatusFilterOptions",
    "any",
    "extension"
})
public class MetadataConfigurationOptions {

    @XmlElement(name = "PTZStatusFilterOptions", required = true)
    protected PTZStatusFilterOptions ptzStatusFilterOptions;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlElement(name = "Extension")
    protected MetadataConfigurationOptionsExtension extension;
    @XmlAttribute(name = "GeoLocation")
    protected Boolean geoLocation;
    @XmlAttribute(name = "MaxContentFilterSize")
    protected Integer maxContentFilterSize;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * ��ȡptzStatusFilterOptions���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link PTZStatusFilterOptions }
     *     
     */
    public PTZStatusFilterOptions getPTZStatusFilterOptions() {
        return ptzStatusFilterOptions;
    }

    /**
     * ����ptzStatusFilterOptions���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link PTZStatusFilterOptions }
     *     
     */
    public void setPTZStatusFilterOptions(PTZStatusFilterOptions value) {
        this.ptzStatusFilterOptions = value;
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
     *     {@link MetadataConfigurationOptionsExtension }
     *     
     */
    public MetadataConfigurationOptionsExtension getExtension() {
        return extension;
    }

    /**
     * ����extension���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link MetadataConfigurationOptionsExtension }
     *     
     */
    public void setExtension(MetadataConfigurationOptionsExtension value) {
        this.extension = value;
    }

    /**
     * ��ȡgeoLocation���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isGeoLocation() {
        return geoLocation;
    }

    /**
     * ����geoLocation���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setGeoLocation(Boolean value) {
        this.geoLocation = value;
    }

    /**
     * ��ȡmaxContentFilterSize���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxContentFilterSize() {
        return maxContentFilterSize;
    }

    /**
     * ����maxContentFilterSize���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxContentFilterSize(Integer value) {
        this.maxContentFilterSize = value;
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
