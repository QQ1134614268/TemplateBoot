
package org.onvif.ver10.schema;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * <p>PTZPresetTourStatus complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="PTZPresetTourStatus">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="State" type="{http://www.onvif.org/ver10/schema}PTZPresetTourState"/>
 *         &lt;element name="CurrentTourSpot" type="{http://www.onvif.org/ver10/schema}PTZPresetTourSpot" minOccurs="0"/>
 *         &lt;element name="Extension" type="{http://www.onvif.org/ver10/schema}PTZPresetTourStatusExtension" minOccurs="0"/>
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
@XmlType(name = "PTZPresetTourStatus", propOrder = {
    "state",
    "currentTourSpot",
    "extension"
})
public class PTZPresetTourStatus {

    @XmlElement(name = "State", required = true)
    @XmlSchemaType(name = "string")
    protected PTZPresetTourState state;
    @XmlElement(name = "CurrentTourSpot")
    protected PTZPresetTourSpot currentTourSpot;
    @XmlElement(name = "Extension")
    protected PTZPresetTourStatusExtension extension;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * ��ȡstate���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link PTZPresetTourState }
     *     
     */
    public PTZPresetTourState getState() {
        return state;
    }

    /**
     * ����state���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link PTZPresetTourState }
     *     
     */
    public void setState(PTZPresetTourState value) {
        this.state = value;
    }

    /**
     * ��ȡcurrentTourSpot���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link PTZPresetTourSpot }
     *     
     */
    public PTZPresetTourSpot getCurrentTourSpot() {
        return currentTourSpot;
    }

    /**
     * ����currentTourSpot���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link PTZPresetTourSpot }
     *     
     */
    public void setCurrentTourSpot(PTZPresetTourSpot value) {
        this.currentTourSpot = value;
    }

    /**
     * ��ȡextension���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link PTZPresetTourStatusExtension }
     *     
     */
    public PTZPresetTourStatusExtension getExtension() {
        return extension;
    }

    /**
     * ����extension���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link PTZPresetTourStatusExtension }
     *     
     */
    public void setExtension(PTZPresetTourStatusExtension value) {
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
