
package com.it.webservice.onvif.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="IPv4Address" type="{http://www.onvif.org/ver10/schema}IPv4Address" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="IPv6Address" type="{http://www.onvif.org/ver10/schema}IPv6Address" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "iPv4Address",
    "iPv6Address"
})
@XmlRootElement(name = "SetNetworkDefaultGateway", namespace = "http://www.onvif.org/ver10/device/wsdl")
public class SetNetworkDefaultGateway {

    @XmlElement(name = "IPv4Address", namespace = "http://www.onvif.org/ver10/device/wsdl")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected List<String> iPv4Address;
    @XmlElement(name = "IPv6Address", namespace = "http://www.onvif.org/ver10/device/wsdl")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected List<String> iPv6Address;

    /**
     * Gets the value of the iPv4Address property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the iPv4Address property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIPv4Address().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getIPv4Address() {
        if (iPv4Address == null) {
            iPv4Address = new ArrayList<String>();
        }
        return this.iPv4Address;
    }

    /**
     * Gets the value of the iPv6Address property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the iPv6Address property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIPv6Address().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getIPv6Address() {
        if (iPv6Address == null) {
            iPv6Address = new ArrayList<String>();
        }
        return this.iPv6Address;
    }

}
