
package org.onvif.ver10.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>LocationEntity complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="LocationEntity">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GeoLocation" type="{http://www.onvif.org/ver10/schema}GeoLocation" minOccurs="0"/>
 *         &lt;element name="GeoOrientation" type="{http://www.onvif.org/ver10/schema}GeoOrientation" minOccurs="0"/>
 *         &lt;element name="LocalLocation" type="{http://www.onvif.org/ver10/schema}LocalLocation" minOccurs="0"/>
 *         &lt;element name="LocalOrientation" type="{http://www.onvif.org/ver10/schema}LocalOrientation" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Entity" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Token" type="{http://www.onvif.org/ver10/schema}ReferenceToken" />
 *       &lt;attribute name="Fixed" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="GeoSource" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="AutoGeo" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LocationEntity", propOrder = {
    "geoLocation",
    "geoOrientation",
    "localLocation",
    "localOrientation"
})
public class LocationEntity {

    @XmlElement(name = "GeoLocation")
    protected GeoLocation geoLocation;
    @XmlElement(name = "GeoOrientation")
    protected GeoOrientation geoOrientation;
    @XmlElement(name = "LocalLocation")
    protected LocalLocation localLocation;
    @XmlElement(name = "LocalOrientation")
    protected LocalOrientation localOrientation;
    @XmlAttribute(name = "Entity")
    protected String entity;
    @XmlAttribute(name = "Token")
    protected String token;
    @XmlAttribute(name = "Fixed")
    protected Boolean fixed;
    @XmlAttribute(name = "GeoSource")
    @XmlSchemaType(name = "anyURI")
    protected String geoSource;
    @XmlAttribute(name = "AutoGeo")
    protected Boolean autoGeo;

    /**
     * ��ȡgeoLocation���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link GeoLocation }
     *     
     */
    public GeoLocation getGeoLocation() {
        return geoLocation;
    }

    /**
     * ����geoLocation���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link GeoLocation }
     *     
     */
    public void setGeoLocation(GeoLocation value) {
        this.geoLocation = value;
    }

    /**
     * ��ȡgeoOrientation���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link GeoOrientation }
     *     
     */
    public GeoOrientation getGeoOrientation() {
        return geoOrientation;
    }

    /**
     * ����geoOrientation���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link GeoOrientation }
     *     
     */
    public void setGeoOrientation(GeoOrientation value) {
        this.geoOrientation = value;
    }

    /**
     * ��ȡlocalLocation���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link LocalLocation }
     *     
     */
    public LocalLocation getLocalLocation() {
        return localLocation;
    }

    /**
     * ����localLocation���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link LocalLocation }
     *     
     */
    public void setLocalLocation(LocalLocation value) {
        this.localLocation = value;
    }

    /**
     * ��ȡlocalOrientation���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link LocalOrientation }
     *     
     */
    public LocalOrientation getLocalOrientation() {
        return localOrientation;
    }

    /**
     * ����localOrientation���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link LocalOrientation }
     *     
     */
    public void setLocalOrientation(LocalOrientation value) {
        this.localOrientation = value;
    }

    /**
     * ��ȡentity���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEntity() {
        return entity;
    }

    /**
     * ����entity���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntity(String value) {
        this.entity = value;
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
     * ��ȡfixed���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFixed() {
        return fixed;
    }

    /**
     * ����fixed���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFixed(Boolean value) {
        this.fixed = value;
    }

    /**
     * ��ȡgeoSource���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGeoSource() {
        return geoSource;
    }

    /**
     * ����geoSource���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGeoSource(String value) {
        this.geoSource = value;
    }

    /**
     * ��ȡautoGeo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAutoGeo() {
        return autoGeo;
    }

    /**
     * ����autoGeo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAutoGeo(Boolean value) {
        this.autoGeo = value;
    }

}
