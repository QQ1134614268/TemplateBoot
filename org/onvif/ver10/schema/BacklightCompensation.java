
package org.onvif.ver10.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>BacklightCompensation complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="BacklightCompensation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Mode" type="{http://www.onvif.org/ver10/schema}BacklightCompensationMode"/>
 *         &lt;element name="Level" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BacklightCompensation", propOrder = {
    "mode",
    "level"
})
public class BacklightCompensation {

    @XmlElement(name = "Mode", required = true)
    @XmlSchemaType(name = "string")
    protected BacklightCompensationMode mode;
    @XmlElement(name = "Level")
    protected float level;

    /**
     * ��ȡmode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BacklightCompensationMode }
     *     
     */
    public BacklightCompensationMode getMode() {
        return mode;
    }

    /**
     * ����mode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BacklightCompensationMode }
     *     
     */
    public void setMode(BacklightCompensationMode value) {
        this.mode = value;
    }

    /**
     * ��ȡlevel���Ե�ֵ��
     * 
     */
    public float getLevel() {
        return level;
    }

    /**
     * ����level���Ե�ֵ��
     * 
     */
    public void setLevel(float value) {
        this.level = value;
    }

}
