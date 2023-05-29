
package com.it.sim.webservice.onvif.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="NetworkInterfaces" type="{http://www.onvif.org/ver10/schema}NetworkInterface" maxOccurs="unbounded"/&gt;
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
    "networkInterfaces"
})
@XmlRootElement(name = "GetNetworkInterfacesResponse", namespace = "http://www.onvif.org/ver10/device/wsdl")
public class GetNetworkInterfacesResponse {

    @XmlElement(name = "NetworkInterfaces", namespace = "http://www.onvif.org/ver10/device/wsdl", required = true)
    protected List<NetworkInterface> networkInterfaces;

    /**
     * Gets the value of the networkInterfaces property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the networkInterfaces property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNetworkInterfaces().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NetworkInterface }
     * 
     * 
     */
    public List<NetworkInterface> getNetworkInterfaces() {
        if (networkInterfaces == null) {
            networkInterfaces = new ArrayList<NetworkInterface>();
        }
        return this.networkInterfaces;
    }

}
