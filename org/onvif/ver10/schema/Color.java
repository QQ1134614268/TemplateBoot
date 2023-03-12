
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
 * <p>Color complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="Color">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="X" use="required" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="Y" use="required" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="Z" use="required" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="Colorspace" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="Likelihood" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;anyAttribute processContents='lax'/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Color")
public class Color {

    @XmlAttribute(name = "X", required = true)
    protected float x;
    @XmlAttribute(name = "Y", required = true)
    protected float y;
    @XmlAttribute(name = "Z", required = true)
    protected float z;
    @XmlAttribute(name = "Colorspace")
    @XmlSchemaType(name = "anyURI")
    protected String colorspace;
    @XmlAttribute(name = "Likelihood")
    protected Float likelihood;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * ��ȡx���Ե�ֵ��
     * 
     */
    public float getX() {
        return x;
    }

    /**
     * ����x���Ե�ֵ��
     * 
     */
    public void setX(float value) {
        this.x = value;
    }

    /**
     * ��ȡy���Ե�ֵ��
     * 
     */
    public float getY() {
        return y;
    }

    /**
     * ����y���Ե�ֵ��
     * 
     */
    public void setY(float value) {
        this.y = value;
    }

    /**
     * ��ȡz���Ե�ֵ��
     * 
     */
    public float getZ() {
        return z;
    }

    /**
     * ����z���Ե�ֵ��
     * 
     */
    public void setZ(float value) {
        this.z = value;
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
     * ��ȡlikelihood���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getLikelihood() {
        return likelihood;
    }

    /**
     * ����likelihood���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setLikelihood(Float value) {
        this.likelihood = value;
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
