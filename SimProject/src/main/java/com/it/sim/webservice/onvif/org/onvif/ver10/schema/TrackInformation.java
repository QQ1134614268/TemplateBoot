
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
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import org.w3c.dom.Element;


/**
 * <p>TrackInformation complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="TrackInformation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TrackToken" type="{http://www.onvif.org/ver10/schema}TrackReference"/>
 *         &lt;element name="TrackType" type="{http://www.onvif.org/ver10/schema}TrackType"/>
 *         &lt;element name="Description" type="{http://www.onvif.org/ver10/schema}Description"/>
 *         &lt;element name="DataFrom" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="DataTo" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
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
@XmlType(name = "TrackInformation", propOrder = {
    "trackToken",
    "trackType",
    "description",
    "dataFrom",
    "dataTo",
    "any"
})
public class TrackInformation {

    @XmlElement(name = "TrackToken", required = true)
    protected String trackToken;
    @XmlElement(name = "TrackType", required = true)
    @XmlSchemaType(name = "string")
    protected TrackType trackType;
    @XmlElement(name = "Description", required = true)
    protected String description;
    @XmlElement(name = "DataFrom", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataFrom;
    @XmlElement(name = "DataTo", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataTo;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * 获取trackToken属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrackToken() {
        return trackToken;
    }

    /**
     * 设置trackToken属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrackToken(String value) {
        this.trackToken = value;
    }

    /**
     * 获取trackType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link TrackType }
     *     
     */
    public TrackType getTrackType() {
        return trackType;
    }

    /**
     * 设置trackType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link TrackType }
     *     
     */
    public void setTrackType(TrackType value) {
        this.trackType = value;
    }

    /**
     * 获取description属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置description属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * 获取dataFrom属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataFrom() {
        return dataFrom;
    }

    /**
     * 设置dataFrom属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataFrom(XMLGregorianCalendar value) {
        this.dataFrom = value;
    }

    /**
     * 获取dataTo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataTo() {
        return dataTo;
    }

    /**
     * 设置dataTo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataTo(XMLGregorianCalendar value) {
        this.dataTo = value;
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
