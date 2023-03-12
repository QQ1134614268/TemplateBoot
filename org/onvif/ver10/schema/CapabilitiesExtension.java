
package org.onvif.ver10.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.w3c.dom.Element;


/**
 * <p>CapabilitiesExtension complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="CapabilitiesExtension">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="DeviceIO" type="{http://www.onvif.org/ver10/schema}DeviceIOCapabilities" minOccurs="0"/>
 *         &lt;element name="Display" type="{http://www.onvif.org/ver10/schema}DisplayCapabilities" minOccurs="0"/>
 *         &lt;element name="Recording" type="{http://www.onvif.org/ver10/schema}RecordingCapabilities" minOccurs="0"/>
 *         &lt;element name="Search" type="{http://www.onvif.org/ver10/schema}SearchCapabilities" minOccurs="0"/>
 *         &lt;element name="Replay" type="{http://www.onvif.org/ver10/schema}ReplayCapabilities" minOccurs="0"/>
 *         &lt;element name="Receiver" type="{http://www.onvif.org/ver10/schema}ReceiverCapabilities" minOccurs="0"/>
 *         &lt;element name="AnalyticsDevice" type="{http://www.onvif.org/ver10/schema}AnalyticsDeviceCapabilities" minOccurs="0"/>
 *         &lt;element name="Extensions" type="{http://www.onvif.org/ver10/schema}CapabilitiesExtension2" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CapabilitiesExtension", propOrder = {
    "any",
    "deviceIO",
    "display",
    "recording",
    "search",
    "replay",
    "receiver",
    "analyticsDevice",
    "extensions"
})
public class CapabilitiesExtension {

    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlElement(name = "DeviceIO")
    protected DeviceIOCapabilities deviceIO;
    @XmlElement(name = "Display")
    protected DisplayCapabilities display;
    @XmlElement(name = "Recording")
    protected RecordingCapabilities recording;
    @XmlElement(name = "Search")
    protected SearchCapabilities search;
    @XmlElement(name = "Replay")
    protected ReplayCapabilities replay;
    @XmlElement(name = "Receiver")
    protected ReceiverCapabilities receiver;
    @XmlElement(name = "AnalyticsDevice")
    protected AnalyticsDeviceCapabilities analyticsDevice;
    @XmlElement(name = "Extensions")
    protected CapabilitiesExtension2 extensions;

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
     * ��ȡdeviceIO���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link DeviceIOCapabilities }
     *     
     */
    public DeviceIOCapabilities getDeviceIO() {
        return deviceIO;
    }

    /**
     * ����deviceIO���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link DeviceIOCapabilities }
     *     
     */
    public void setDeviceIO(DeviceIOCapabilities value) {
        this.deviceIO = value;
    }

    /**
     * ��ȡdisplay���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link DisplayCapabilities }
     *     
     */
    public DisplayCapabilities getDisplay() {
        return display;
    }

    /**
     * ����display���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link DisplayCapabilities }
     *     
     */
    public void setDisplay(DisplayCapabilities value) {
        this.display = value;
    }

    /**
     * ��ȡrecording���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link RecordingCapabilities }
     *     
     */
    public RecordingCapabilities getRecording() {
        return recording;
    }

    /**
     * ����recording���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link RecordingCapabilities }
     *     
     */
    public void setRecording(RecordingCapabilities value) {
        this.recording = value;
    }

    /**
     * ��ȡsearch���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link SearchCapabilities }
     *     
     */
    public SearchCapabilities getSearch() {
        return search;
    }

    /**
     * ����search���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link SearchCapabilities }
     *     
     */
    public void setSearch(SearchCapabilities value) {
        this.search = value;
    }

    /**
     * ��ȡreplay���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ReplayCapabilities }
     *     
     */
    public ReplayCapabilities getReplay() {
        return replay;
    }

    /**
     * ����replay���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ReplayCapabilities }
     *     
     */
    public void setReplay(ReplayCapabilities value) {
        this.replay = value;
    }

    /**
     * ��ȡreceiver���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ReceiverCapabilities }
     *     
     */
    public ReceiverCapabilities getReceiver() {
        return receiver;
    }

    /**
     * ����receiver���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ReceiverCapabilities }
     *     
     */
    public void setReceiver(ReceiverCapabilities value) {
        this.receiver = value;
    }

    /**
     * ��ȡanalyticsDevice���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link AnalyticsDeviceCapabilities }
     *     
     */
    public AnalyticsDeviceCapabilities getAnalyticsDevice() {
        return analyticsDevice;
    }

    /**
     * ����analyticsDevice���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link AnalyticsDeviceCapabilities }
     *     
     */
    public void setAnalyticsDevice(AnalyticsDeviceCapabilities value) {
        this.analyticsDevice = value;
    }

    /**
     * ��ȡextensions���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CapabilitiesExtension2 }
     *     
     */
    public CapabilitiesExtension2 getExtensions() {
        return extensions;
    }

    /**
     * ����extensions���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CapabilitiesExtension2 }
     *     
     */
    public void setExtensions(CapabilitiesExtension2 value) {
        this.extensions = value;
    }

}
