
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
 * <p>NetworkZeroConfigurationExtension complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="NetworkZeroConfigurationExtension"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="Additional" type="{http://www.onvif.org/ver10/schema}NetworkZeroConfiguration" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="Extension" type="{http://www.onvif.org/ver10/schema}NetworkZeroConfigurationExtension2" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NetworkZeroConfigurationExtension", propOrder = {
    "any",
    "additional",
    "extension"
})
public class NetworkZeroConfigurationExtension {

    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlElement(name = "Additional")
    protected List<NetworkZeroConfiguration> additional;
    @XmlElement(name = "Extension")
    protected NetworkZeroConfigurationExtension2 extension;

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
     * Gets the value of the additional property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the additional property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditional().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NetworkZeroConfiguration }
     * 
     * 
     */
    public List<NetworkZeroConfiguration> getAdditional() {
        if (additional == null) {
            additional = new ArrayList<NetworkZeroConfiguration>();
        }
        return this.additional;
    }

    /**
     * 获取extension属性的值。
     * 
     * @return
     *     possible object is
     *     {@link NetworkZeroConfigurationExtension2 }
     *     
     */
    public NetworkZeroConfigurationExtension2 getExtension() {
        return extension;
    }

    /**
     * 设置extension属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link NetworkZeroConfigurationExtension2 }
     *     
     */
    public void setExtension(NetworkZeroConfigurationExtension2 value) {
        this.extension = value;
    }

}
