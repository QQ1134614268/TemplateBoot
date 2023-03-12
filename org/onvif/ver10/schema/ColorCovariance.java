
package org.onvif.ver10.schema;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * <p>ColorCovariance complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ColorCovariance">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="XX" use="required" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="YY" use="required" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="ZZ" use="required" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="XY" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="XZ" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="YZ" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="Colorspace" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;anyAttribute processContents='lax'/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ColorCovariance")
public class ColorCovariance {

    @XmlAttribute(name = "XX", required = true)
    protected float xx;
    @XmlAttribute(name = "YY", required = true)
    protected float yy;
    @XmlAttribute(name = "ZZ", required = true)
    protected float zz;
    @XmlAttribute(name = "XY")
    protected Float xy;
    @XmlAttribute(name = "XZ")
    protected Float xz;
    @XmlAttribute(name = "YZ")
    protected Float yz;
    @XmlAttribute(name = "Colorspace")
    @XmlSchemaType(name = "anyURI")
    protected String colorspace;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * ��ȡxx���Ե�ֵ��
     * 
     */
    public float getXX() {
        return xx;
    }

    /**
     * ����xx���Ե�ֵ��
     * 
     */
    public void setXX(float value) {
        this.xx = value;
    }

    /**
     * ��ȡyy���Ե�ֵ��
     * 
     */
    public float getYY() {
        return yy;
    }

    /**
     * ����yy���Ե�ֵ��
     * 
     */
    public void setYY(float value) {
        this.yy = value;
    }

    /**
     * ��ȡzz���Ե�ֵ��
     * 
     */
    public float getZZ() {
        return zz;
    }

    /**
     * ����zz���Ե�ֵ��
     * 
     */
    public void setZZ(float value) {
        this.zz = value;
    }

    /**
     * ��ȡxy���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getXY() {
        return xy;
    }

    /**
     * ����xy���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setXY(Float value) {
        this.xy = value;
    }

    /**
     * ��ȡxz���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getXZ() {
        return xz;
    }

    /**
     * ����xz���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setXZ(Float value) {
        this.xz = value;
    }

    /**
     * ��ȡyz���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getYZ() {
        return yz;
    }

    /**
     * ����yz���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setYZ(Float value) {
        this.yz = value;
    }

    /**
     * ��ȡcolorspace���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColorspace() {
        return colorspace;
    }

    /**
     * ����colorspace���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColorspace(String value) {
        this.colorspace = value;
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
