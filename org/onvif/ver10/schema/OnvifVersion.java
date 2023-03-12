
package org.onvif.ver10.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>OnvifVersion complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="OnvifVersion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Major" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Minor" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OnvifVersion", propOrder = {
    "major",
    "minor"
})
public class OnvifVersion {

    @XmlElement(name = "Major")
    protected int major;
    @XmlElement(name = "Minor")
    protected int minor;

    /**
     * ��ȡmajor���Ե�ֵ��
     * 
     */
    public int getMajor() {
        return major;
    }

    /**
     * ����major���Ե�ֵ��
     * 
     */
    public void setMajor(int value) {
        this.major = value;
    }

    /**
     * ��ȡminor���Ե�ֵ��
     * 
     */
    public int getMinor() {
        return minor;
    }

    /**
     * ����minor���Ե�ֵ��
     * 
     */
    public void setMinor(int value) {
        this.minor = value;
    }

}
