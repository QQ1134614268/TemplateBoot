
package org.onvif.ver10.device.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="StorageConfiguration" type="{http://www.onvif.org/ver10/device/wsdl}StorageConfigurationData"/>
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
    "storageConfiguration"
})
@XmlRootElement(name = "CreateStorageConfiguration")
public class CreateStorageConfiguration {

    @XmlElement(name = "StorageConfiguration", required = true)
    protected StorageConfigurationData storageConfiguration;

    /**
     * ��ȡstorageConfiguration���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link StorageConfigurationData }
     *     
     */
    public StorageConfigurationData getStorageConfiguration() {
        return storageConfiguration;
    }

    /**
     * ����storageConfiguration���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link StorageConfigurationData }
     *     
     */
    public void setStorageConfiguration(StorageConfigurationData value) {
        this.storageConfiguration = value;
    }

}
