
package com.it.webservice.onvif.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>StorageConfiguration complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="StorageConfiguration"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.onvif.org/ver10/schema}DeviceEntity"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Data" type="{http://www.onvif.org/ver10/device/wsdl}StorageConfigurationData"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StorageConfiguration", namespace = "http://www.onvif.org/ver10/device/wsdl", propOrder = {
    "data"
})
public class StorageConfiguration
    extends DeviceEntity
{

    @XmlElement(name = "Data", required = true)
    protected StorageConfigurationData data;

    /**
     * 获取data属性的值。
     * 
     * @return
     *     possible object is
     *     {@link StorageConfigurationData }
     *     
     */
    public StorageConfigurationData getData() {
        return data;
    }

    /**
     * 设置data属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link StorageConfigurationData }
     *     
     */
    public void setData(StorageConfigurationData value) {
        this.data = value;
    }

}
