
package org.onvif.ver10.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Space2DDescription complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="Space2DDescription">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="URI" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *         &lt;element name="XRange" type="{http://www.onvif.org/ver10/schema}FloatRange"/>
 *         &lt;element name="YRange" type="{http://www.onvif.org/ver10/schema}FloatRange"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Space2DDescription", propOrder = {
    "uri",
    "xRange",
    "yRange"
})
public class Space2DDescription {

    @XmlElement(name = "URI", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String uri;
    @XmlElement(name = "XRange", required = true)
    protected FloatRange xRange;
    @XmlElement(name = "YRange", required = true)
    protected FloatRange yRange;

    /**
     * ��ȡuri���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getURI() {
        return uri;
    }

    /**
     * ����uri���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setURI(String value) {
        this.uri = value;
    }

    /**
     * ��ȡxRange���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link FloatRange }
     *     
     */
    public FloatRange getXRange() {
        return xRange;
    }

    /**
     * ����xRange���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link FloatRange }
     *     
     */
    public void setXRange(FloatRange value) {
        this.xRange = value;
    }

    /**
     * ��ȡyRange���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link FloatRange }
     *     
     */
    public FloatRange getYRange() {
        return yRange;
    }

    /**
     * ����yRange���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link FloatRange }
     *     
     */
    public void setYRange(FloatRange value) {
        this.yRange = value;
    }

}
