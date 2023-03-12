
package org.onvif.ver10.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SceneOrientation complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="SceneOrientation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Mode" type="{http://www.onvif.org/ver10/schema}SceneOrientationMode"/>
 *         &lt;element name="Orientation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SceneOrientation", propOrder = {
    "mode",
    "orientation"
})
public class SceneOrientation {

    @XmlElement(name = "Mode", required = true)
    @XmlSchemaType(name = "string")
    protected SceneOrientationMode mode;
    @XmlElement(name = "Orientation")
    protected String orientation;

    /**
     * ��ȡmode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link SceneOrientationMode }
     *     
     */
    public SceneOrientationMode getMode() {
        return mode;
    }

    /**
     * ����mode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link SceneOrientationMode }
     *     
     */
    public void setMode(SceneOrientationMode value) {
        this.mode = value;
    }

    /**
     * ��ȡorientation���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrientation() {
        return orientation;
    }

    /**
     * ����orientation���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrientation(String value) {
        this.orientation = value;
    }

}
