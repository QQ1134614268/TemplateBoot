
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
 * <p>PTZStatusFilterOptions complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="PTZStatusFilterOptions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PanTiltStatusSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ZoomStatusSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="PanTiltPositionSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ZoomPositionSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Extension" type="{http://www.onvif.org/ver10/schema}PTZStatusFilterOptionsExtension" minOccurs="0"/>
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
@XmlType(name = "PTZStatusFilterOptions", propOrder = {
    "panTiltStatusSupported",
    "zoomStatusSupported",
    "any",
    "panTiltPositionSupported",
    "zoomPositionSupported",
    "extension"
})
public class PTZStatusFilterOptions {

    @XmlElement(name = "PanTiltStatusSupported")
    protected boolean panTiltStatusSupported;
    @XmlElement(name = "ZoomStatusSupported")
    protected boolean zoomStatusSupported;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlElement(name = "PanTiltPositionSupported")
    protected Boolean panTiltPositionSupported;
    @XmlElement(name = "ZoomPositionSupported")
    protected Boolean zoomPositionSupported;
    @XmlElement(name = "Extension")
    protected PTZStatusFilterOptionsExtension extension;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * ��ȡpanTiltStatusSupported���Ե�ֵ��
     * 
     */
    public boolean isPanTiltStatusSupported() {
        return panTiltStatusSupported;
    }

    /**
     * ����panTiltStatusSupported���Ե�ֵ��
     * 
     */
    public void setPanTiltStatusSupported(boolean value) {
        this.panTiltStatusSupported = value;
    }

    /**
     * ��ȡzoomStatusSupported���Ե�ֵ��
     * 
     */
    public boolean isZoomStatusSupported() {
        return zoomStatusSupported;
    }

    /**
     * ����zoomStatusSupported���Ե�ֵ��
     * 
     */
    public void setZoomStatusSupported(boolean value) {
        this.zoomStatusSupported = value;
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
     * ��ȡpanTiltPositionSupported���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPanTiltPositionSupported() {
        return panTiltPositionSupported;
    }

    /**
     * ����panTiltPositionSupported���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPanTiltPositionSupported(Boolean value) {
        this.panTiltPositionSupported = value;
    }

    /**
     * ��ȡzoomPositionSupported���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isZoomPositionSupported() {
        return zoomPositionSupported;
    }

    /**
     * ����zoomPositionSupported���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setZoomPositionSupported(Boolean value) {
        this.zoomPositionSupported = value;
    }

    /**
     * ��ȡextension���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link PTZStatusFilterOptionsExtension }
     *     
     */
    public PTZStatusFilterOptionsExtension getExtension() {
        return extension;
    }

    /**
     * ����extension���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link PTZStatusFilterOptionsExtension }
     *     
     */
    public void setExtension(PTZStatusFilterOptionsExtension value) {
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
