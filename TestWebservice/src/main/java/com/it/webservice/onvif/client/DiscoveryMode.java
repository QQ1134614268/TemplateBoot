
package com.it.webservice.onvif.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>DiscoveryMode的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <pre>
 * &lt;simpleType name="DiscoveryMode"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Discoverable"/&gt;
 *     &lt;enumeration value="NonDiscoverable"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "DiscoveryMode")
@XmlEnum
public enum DiscoveryMode {

    @XmlEnumValue("Discoverable")
    DISCOVERABLE("Discoverable"),
    @XmlEnumValue("NonDiscoverable")
    NON_DISCOVERABLE("NonDiscoverable");
    private final String value;

    DiscoveryMode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DiscoveryMode fromValue(String v) {
        for (DiscoveryMode c: DiscoveryMode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
