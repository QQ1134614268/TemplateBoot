
package org.onvif.ver10.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Vector2D complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="Vector2D">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="x" use="required" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="y" use="required" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="space" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Vector2D")
public class Vector2D {

    @XmlAttribute(name = "x", required = true)
    protected float x;
    @XmlAttribute(name = "y", required = true)
    protected float y;
    @XmlAttribute(name = "space")
    @XmlSchemaType(name = "anyURI")
    protected String space;

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
     * ��ȡspace���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpace() {
        return space;
    }

    /**
     * ����space���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpace(String value) {
        this.space = value;
    }

}
