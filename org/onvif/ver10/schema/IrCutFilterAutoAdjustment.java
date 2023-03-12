
package org.onvif.ver10.schema;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.Duration;
import javax.xml.namespace.QName;


/**
 * <p>IrCutFilterAutoAdjustment complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="IrCutFilterAutoAdjustment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BoundaryType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="BoundaryOffset" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="ResponseTime" type="{http://www.w3.org/2001/XMLSchema}duration" minOccurs="0"/>
 *         &lt;element name="Extension" type="{http://www.onvif.org/ver10/schema}IrCutFilterAutoAdjustmentExtension" minOccurs="0"/>
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
@XmlType(name = "IrCutFilterAutoAdjustment", propOrder = {
    "boundaryType",
    "boundaryOffset",
    "responseTime",
    "extension"
})
public class IrCutFilterAutoAdjustment {

    @XmlElement(name = "BoundaryType", required = true)
    protected String boundaryType;
    @XmlElement(name = "BoundaryOffset")
    protected Float boundaryOffset;
    @XmlElement(name = "ResponseTime")
    protected Duration responseTime;
    @XmlElement(name = "Extension")
    protected IrCutFilterAutoAdjustmentExtension extension;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * ��ȡboundaryType���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBoundaryType() {
        return boundaryType;
    }

    /**
     * ����boundaryType���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBoundaryType(String value) {
        this.boundaryType = value;
    }

    /**
     * ��ȡboundaryOffset���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getBoundaryOffset() {
        return boundaryOffset;
    }

    /**
     * ����boundaryOffset���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setBoundaryOffset(Float value) {
        this.boundaryOffset = value;
    }

    /**
     * ��ȡresponseTime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getResponseTime() {
        return responseTime;
    }

    /**
     * ����responseTime���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setResponseTime(Duration value) {
        this.responseTime = value;
    }

    /**
     * ��ȡextension���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link IrCutFilterAutoAdjustmentExtension }
     *     
     */
    public IrCutFilterAutoAdjustmentExtension getExtension() {
        return extension;
    }

    /**
     * ����extension���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link IrCutFilterAutoAdjustmentExtension }
     *     
     */
    public void setExtension(IrCutFilterAutoAdjustmentExtension value) {
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
