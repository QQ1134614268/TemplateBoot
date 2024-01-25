
package com.it.webservice.onvif.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>StorageType的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <pre>
 * &lt;simpleType name="StorageType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="NFS"/&gt;
 *     &lt;enumeration value="CIFS"/&gt;
 *     &lt;enumeration value="CDMI"/&gt;
 *     &lt;enumeration value="FTP"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "StorageType", namespace = "http://www.onvif.org/ver10/device/wsdl")
@XmlEnum
public enum StorageType {


    /**
     * NFS protocol
     * 
     */
    NFS,

    /**
     * CIFS protocol
     * 
     */
    CIFS,

    /**
     * CDMI protocol
     * 
     */
    CDMI,

    /**
     * FTP protocol
     * 
     */
    FTP;

    public String value() {
        return name();
    }

    public static StorageType fromValue(String v) {
        return valueOf(v);
    }

}
