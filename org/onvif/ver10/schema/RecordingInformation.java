
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
 * <p>RecordingInformation complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="RecordingInformation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RecordingToken" type="{http://www.onvif.org/ver10/schema}RecordingReference"/>
 *         &lt;element name="Source" type="{http://www.onvif.org/ver10/schema}RecordingSourceInformation"/>
 *         &lt;element name="EarliestRecording" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="LatestRecording" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Content" type="{http://www.onvif.org/ver10/schema}Description"/>
 *         &lt;element name="Track" type="{http://www.onvif.org/ver10/schema}TrackInformation" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="RecordingStatus" type="{http://www.onvif.org/ver10/schema}RecordingStatus"/>
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
@XmlType(name = "RecordingInformation", propOrder = {
    "recordingToken",
    "source",
    "earliestRecording",
    "latestRecording",
    "content",
    "track",
    "recordingStatus",
    "any"
})
public class RecordingInformation {

    @XmlElement(name = "RecordingToken", required = true)
    protected String recordingToken;
    @XmlElement(name = "Source", required = true)
    protected RecordingSourceInformation source;
    @XmlElement(name = "EarliestRecording")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar earliestRecording;
    @XmlElement(name = "LatestRecording")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar latestRecording;
    @XmlElement(name = "Content", required = true)
    protected String content;
    @XmlElement(name = "Track")
    protected List<TrackInformation> track;
    @XmlElement(name = "RecordingStatus", required = true)
    @XmlSchemaType(name = "string")
    protected RecordingStatus recordingStatus;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * ��ȡrecordingToken���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecordingToken() {
        return recordingToken;
    }

    /**
     * ����recordingToken���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecordingToken(String value) {
        this.recordingToken = value;
    }

    /**
     * ��ȡsource���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link RecordingSourceInformation }
     *     
     */
    public RecordingSourceInformation getSource() {
        return source;
    }

    /**
     * ����source���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link RecordingSourceInformation }
     *     
     */
    public void setSource(RecordingSourceInformation value) {
        this.source = value;
    }

    /**
     * ��ȡearliestRecording���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEarliestRecording() {
        return earliestRecording;
    }

    /**
     * ����earliestRecording���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEarliestRecording(XMLGregorianCalendar value) {
        this.earliestRecording = value;
    }

    /**
     * ��ȡlatestRecording���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLatestRecording() {
        return latestRecording;
    }

    /**
     * ����latestRecording���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLatestRecording(XMLGregorianCalendar value) {
        this.latestRecording = value;
    }

    /**
     * ��ȡcontent���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContent() {
        return content;
    }

    /**
     * ����content���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContent(String value) {
        this.content = value;
    }

    /**
     * Gets the value of the track property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the track property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTrack().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TrackInformation }
     * 
     * 
     */
    public List<TrackInformation> getTrack() {
        if (track == null) {
            track = new ArrayList<TrackInformation>();
        }
        return this.track;
    }

    /**
     * ��ȡrecordingStatus���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link RecordingStatus }
     *     
     */
    public RecordingStatus getRecordingStatus() {
        return recordingStatus;
    }

    /**
     * ����recordingStatus���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link RecordingStatus }
     *     
     */
    public void setRecordingStatus(RecordingStatus value) {
        this.recordingStatus = value;
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
