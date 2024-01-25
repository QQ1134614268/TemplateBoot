
package com.it.webservice.onvif.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>PTZMoveStatus complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="PTZMoveStatus"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PanTilt" type="{http://www.onvif.org/ver10/schema}MoveStatus" minOccurs="0"/&gt;
 *         &lt;element name="Zoom" type="{http://www.onvif.org/ver10/schema}MoveStatus" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
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
     * 获取panTilt属性的值。
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
     * 设置panTilt属性的值。
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
     * 获取zoom属性的值。
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
     * 设置zoom属性的值。
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
