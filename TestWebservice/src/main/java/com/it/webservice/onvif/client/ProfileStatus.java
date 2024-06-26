
package com.it.webservice.onvif.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ProfileStatus complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ProfileStatus"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ActiveConnections" type="{http://www.onvif.org/ver10/schema}ActiveConnection" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="Extension" type="{http://www.onvif.org/ver10/schema}ProfileStatusExtension" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProfileStatus", propOrder = {
    "activeConnections",
    "extension"
})
public class ProfileStatus {

    @XmlElement(name = "ActiveConnections")
    protected List<ActiveConnection> activeConnections;
    @XmlElement(name = "Extension")
    protected ProfileStatusExtension extension;

    /**
     * Gets the value of the activeConnections property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the activeConnections property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActiveConnections().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ActiveConnection }
     * 
     * 
     */
    public List<ActiveConnection> getActiveConnections() {
        if (activeConnections == null) {
            activeConnections = new ArrayList<ActiveConnection>();
        }
        return this.activeConnections;
    }

    /**
     * 获取extension属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ProfileStatusExtension }
     *     
     */
    public ProfileStatusExtension getExtension() {
        return extension;
    }

    /**
     * 设置extension属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ProfileStatusExtension }
     *     
     */
    public void setExtension(ProfileStatusExtension value) {
        this.extension = value;
    }

}
