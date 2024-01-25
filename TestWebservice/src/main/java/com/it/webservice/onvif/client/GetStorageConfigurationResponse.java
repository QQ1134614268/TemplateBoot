
package com.it.webservice.onvif.client;

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
 *         &lt;element name="StorageConfiguration" type="{http://www.onvif.org/ver10/device/wsdl}StorageConfiguration"/&gt;
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
    "storageConfiguration"
})
@XmlRootElement(name = "GetStorageConfigurationResponse", namespace = "http://www.onvif.org/ver10/device/wsdl")
public class GetStorageConfigurationResponse {

    @XmlElement(name = "StorageConfiguration", namespace = "http://www.onvif.org/ver10/device/wsdl", required = true)
    protected StorageConfiguration storageConfiguration;

    /**
     * 获取storageConfiguration属性的值。
     * 
     * @return
     *     possible object is
     *     {@link StorageConfiguration }
     *     
     */
    public StorageConfiguration getStorageConfiguration() {
        return storageConfiguration;
    }

    /**
     * 设置storageConfiguration属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link StorageConfiguration }
     *     
     */
    public void setStorageConfiguration(StorageConfiguration value) {
        this.storageConfiguration = value;
    }

}
