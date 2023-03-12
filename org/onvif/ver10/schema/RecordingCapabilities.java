
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
import javax.xml.namespace.QName;
import org.w3c.dom.Element;


/**
 * <p>RecordingCapabilities complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="RecordingCapabilities">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="XAddr" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *         &lt;element name="ReceiverSource" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="MediaProfileSource" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="DynamicRecordings" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="DynamicTracks" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="MaxStringLength" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "RecordingCapabilities", propOrder = {
    "xAddr",
    "receiverSource",
    "mediaProfileSource",
    "dynamicRecordings",
    "dynamicTracks",
    "maxStringLength",
    "any"
})
public class RecordingCapabilities {

    @XmlElement(name = "XAddr", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String xAddr;
    @XmlElement(name = "ReceiverSource")
    protected boolean receiverSource;
    @XmlElement(name = "MediaProfileSource")
    protected boolean mediaProfileSource;
    @XmlElement(name = "DynamicRecordings")
    protected boolean dynamicRecordings;
    @XmlElement(name = "DynamicTracks")
    protected boolean dynamicTracks;
    @XmlElement(name = "MaxStringLength")
    protected int maxStringLength;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * ��ȡxAddr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXAddr() {
        return xAddr;
    }

    /**
     * ����xAddr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXAddr(String value) {
        this.xAddr = value;
    }

    /**
     * ��ȡreceiverSource���Ե�ֵ��
     * 
     */
    public boolean isReceiverSource() {
        return receiverSource;
    }

    /**
     * ����receiverSource���Ե�ֵ��
     * 
     */
    public void setReceiverSource(boolean value) {
        this.receiverSource = value;
    }

    /**
     * ��ȡmediaProfileSource���Ե�ֵ��
     * 
     */
    public boolean isMediaProfileSource() {
        return mediaProfileSource;
    }

    /**
     * ����mediaProfileSource���Ե�ֵ��
     * 
     */
    public void setMediaProfileSource(boolean value) {
        this.mediaProfileSource = value;
    }

    /**
     * ��ȡdynamicRecordings���Ե�ֵ��
     * 
     */
    public boolean isDynamicRecordings() {
        return dynamicRecordings;
    }

    /**
     * ����dynamicRecordings���Ե�ֵ��
     * 
     */
    public void setDynamicRecordings(boolean value) {
        this.dynamicRecordings = value;
    }

    /**
     * ��ȡdynamicTracks���Ե�ֵ��
     * 
     */
    public boolean isDynamicTracks() {
        return dynamicTracks;
    }

    /**
     * ����dynamicTracks���Ե�ֵ��
     * 
     */
    public void setDynamicTracks(boolean value) {
        this.dynamicTracks = value;
    }

    /**
     * ��ȡmaxStringLength���Ե�ֵ��
     * 
     */
    public int getMaxStringLength() {
        return maxStringLength;
    }

    /**
     * ����maxStringLength���Ե�ֵ��
     * 
     */
    public void setMaxStringLength(int value) {
        this.maxStringLength = value;
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
