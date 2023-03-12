
package org.onvif.ver10.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>PTZMoveStatus complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="PTZMoveStatus">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PanTilt" type="{http://www.onvif.org/ver10/schema}MoveStatus" minOccurs="0"/>
 *         &lt;element name="Zoom" type="{http://www.onvif.org/ver10/schema}MoveStatus" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PTZMoveStatus", propOrder = {
    "panTilt",
    "zoom"
})
public class PTZMoveStatus {

    @XmlElement(name = "PanTilt")
    @XmlSchemaType(name = "string")
    protected MoveStatus panTilt;
    @XmlElement(name = "Zoom")
    @XmlSchemaType(name = "string")
    protected MoveStatus zoom;

    /**
     * ��ȡpanTilt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link MoveStatus }
     *     
     */
    public MoveStatus getPanTilt() {
        return panTilt;
    }

    /**
     * ����panTilt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link MoveStatus }
     *     
     */
    public void setPanTilt(MoveStatus value) {
        this.panTilt = value;
    }

    /**
     * ��ȡzoom���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link MoveStatus }
     *     
     */
    public MoveStatus getZoom() {
        return zoom;
    }

    /**
     * ����zoom���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link MoveStatus }
     *     
     */
    public void setZoom(MoveStatus value) {
        this.zoom = value;
    }

}
