
package org.onvif.ver10.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.Duration;


/**
 * <p>RelayOutputSettings complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="RelayOutputSettings">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Mode" type="{http://www.onvif.org/ver10/schema}RelayMode"/>
 *         &lt;element name="DelayTime" type="{http://www.w3.org/2001/XMLSchema}duration"/>
 *         &lt;element name="IdleState" type="{http://www.onvif.org/ver10/schema}RelayIdleState"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RelayOutputSettings", propOrder = {
    "mode",
    "delayTime",
    "idleState"
})
public class RelayOutputSettings {

    @XmlElement(name = "Mode", required = true)
    @XmlSchemaType(name = "string")
    protected RelayMode mode;
    @XmlElement(name = "DelayTime", required = true)
    protected Duration delayTime;
    @XmlElement(name = "IdleState", required = true)
    @XmlSchemaType(name = "string")
    protected RelayIdleState idleState;

    /**
     * ��ȡmode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link RelayMode }
     *     
     */
    public RelayMode getMode() {
        return mode;
    }

    /**
     * ����mode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link RelayMode }
     *     
     */
    public void setMode(RelayMode value) {
        this.mode = value;
    }

    /**
     * ��ȡdelayTime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getDelayTime() {
        return delayTime;
    }

    /**
     * ����delayTime���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setDelayTime(Duration value) {
        this.delayTime = value;
    }

    /**
     * ��ȡidleState���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link RelayIdleState }
     *     
     */
    public RelayIdleState getIdleState() {
        return idleState;
    }

    /**
     * ����idleState���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link RelayIdleState }
     *     
     */
    public void setIdleState(RelayIdleState value) {
        this.idleState = value;
    }

}
