
package com.it.webservice.onvif.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.w3c.dom.Element;


/**
 * <p>NetworkInterfaceSetConfigurationExtension complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="NetworkInterfaceSetConfigurationExtension"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="Dot3" type="{http://www.onvif.org/ver10/schema}Dot3Configuration" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="Dot11" type="{http://www.onvif.org/ver10/schema}Dot11Configuration" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="Extension" type="{http://www.onvif.org/ver10/schema}NetworkInterfaceSetConfigurationExtension2" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NetworkInterfaceSetConfigurationExtension", propOrder = {
    "any",
    "dot3",
    "dot11",
    "extension"
})
public class NetworkInterfaceSetConfigurationExtension {

    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlElement(name = "Dot3")
    protected List<Dot3Configuration> dot3;
    @XmlElement(name = "Dot11")
    protected List<Dot11Configuration> dot11;
    @XmlElement(name = "Extension")
    protected NetworkInterfaceSetConfigurationExtension2 extension;

    /**
     * Gets the value of the any property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the any property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAny().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * {@link Element }
     * 
     * 
     */
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }

    /**
     * Gets the value of the dot3 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dot3 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDot3().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Dot3Configuration }
     * 
     * 
     */
    public List<Dot3Configuration> getDot3() {
        if (dot3 == null) {
            dot3 = new ArrayList<Dot3Configuration>();
        }
        return this.dot3;
    }

    /**
     * Gets the value of the dot11 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dot11 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDot11().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Dot11Configuration }
     * 
     * 
     */
    public List<Dot11Configuration> getDot11() {
        if (dot11 == null) {
            dot11 = new ArrayList<Dot11Configuration>();
        }
        return this.dot11;
    }

    /**
     * 获取extension属性的值。
     * 
     * @return
     *     possible object is
     *     {@link NetworkInterfaceSetConfigurationExtension2 }
     *     
     */
    public NetworkInterfaceSetConfigurationExtension2 getExtension() {
        return extension;
    }

    /**
     * 设置extension属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link NetworkInterfaceSetConfigurationExtension2 }
     *     
     */
    public void setExtension(NetworkInterfaceSetConfigurationExtension2 value) {
        this.extension = value;
    }

}
