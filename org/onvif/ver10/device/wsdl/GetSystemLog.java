
package org.onvif.ver10.device.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import org.onvif.ver10.schema.SystemLogType;


/**
 * <p>anonymous complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LogType" type="{http://www.onvif.org/ver10/schema}SystemLogType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "logType"
})
@XmlRootElement(name = "GetSystemLog")
public class GetSystemLog {

    @XmlElement(name = "LogType", required = true)
    @XmlSchemaType(name = "string")
    protected SystemLogType logType;

    /**
     * ��ȡlogType���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link SystemLogType }
     *     
     */
    public SystemLogType getLogType() {
        return logType;
    }

    /**
     * ����logType���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link SystemLogType }
     *     
     */
    public void setLogType(SystemLogType value) {
        this.logType = value;
    }

}
