
package org.onvif.ver10.schema;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * <p>Capabilities complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="Capabilities">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Analytics" type="{http://www.onvif.org/ver10/schema}AnalyticsCapabilities" minOccurs="0"/>
 *         &lt;element name="Device" type="{http://www.onvif.org/ver10/schema}DeviceCapabilities" minOccurs="0"/>
 *         &lt;element name="Events" type="{http://www.onvif.org/ver10/schema}EventCapabilities" minOccurs="0"/>
 *         &lt;element name="Imaging" type="{http://www.onvif.org/ver10/schema}ImagingCapabilities" minOccurs="0"/>
 *         &lt;element name="Media" type="{http://www.onvif.org/ver10/schema}MediaCapabilities" minOccurs="0"/>
 *         &lt;element name="PTZ" type="{http://www.onvif.org/ver10/schema}PTZCapabilities" minOccurs="0"/>
 *         &lt;element name="Extension" type="{http://www.onvif.org/ver10/schema}CapabilitiesExtension" minOccurs="0"/>
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
@XmlType(name = "Capabilities", propOrder = {
    "analytics",
    "device",
    "events",
    "imaging",
    "media",
    "ptz",
    "extension"
})
public class Capabilities {

    @XmlElement(name = "Analytics")
    protected AnalyticsCapabilities analytics;
    @XmlElement(name = "Device")
    protected DeviceCapabilities device;
    @XmlElement(name = "Events")
    protected EventCapabilities events;
    @XmlElement(name = "Imaging")
    protected ImagingCapabilities imaging;
    @XmlElement(name = "Media")
    protected MediaCapabilities media;
    @XmlElement(name = "PTZ")
    protected PTZCapabilities ptz;
    @XmlElement(name = "Extension")
    protected CapabilitiesExtension extension;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * ��ȡanalytics���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link AnalyticsCapabilities }
     *     
     */
    public AnalyticsCapabilities getAnalytics() {
        return analytics;
    }

    /**
     * ����analytics���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link AnalyticsCapabilities }
     *     
     */
    public void setAnalytics(AnalyticsCapabilities value) {
        this.analytics = value;
    }

    /**
     * ��ȡdevice���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link DeviceCapabilities }
     *     
     */
    public DeviceCapabilities getDevice() {
        return device;
    }

    /**
     * ����device���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link DeviceCapabilities }
     *     
     */
    public void setDevice(DeviceCapabilities value) {
        this.device = value;
    }

    /**
     * ��ȡevents���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link EventCapabilities }
     *     
     */
    public EventCapabilities getEvents() {
        return events;
    }

    /**
     * ����events���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link EventCapabilities }
     *     
     */
    public void setEvents(EventCapabilities value) {
        this.events = value;
    }

    /**
     * ��ȡimaging���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ImagingCapabilities }
     *     
     */
    public ImagingCapabilities getImaging() {
        return imaging;
    }

    /**
     * ����imaging���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ImagingCapabilities }
     *     
     */
    public void setImaging(ImagingCapabilities value) {
        this.imaging = value;
    }

    /**
     * ��ȡmedia���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link MediaCapabilities }
     *     
     */
    public MediaCapabilities getMedia() {
        return media;
    }

    /**
     * ����media���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link MediaCapabilities }
     *     
     */
    public void setMedia(MediaCapabilities value) {
        this.media = value;
    }

    /**
     * ��ȡptz���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link PTZCapabilities }
     *     
     */
    public PTZCapabilities getPTZ() {
        return ptz;
    }

    /**
     * ����ptz���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link PTZCapabilities }
     *     
     */
    public void setPTZ(PTZCapabilities value) {
        this.ptz = value;
    }

    /**
     * ��ȡextension���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CapabilitiesExtension }
     *     
     */
    public CapabilitiesExtension getExtension() {
        return extension;
    }

    /**
     * ����extension���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CapabilitiesExtension }
     *     
     */
    public void setExtension(CapabilitiesExtension value) {
        this.extension = value;
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
