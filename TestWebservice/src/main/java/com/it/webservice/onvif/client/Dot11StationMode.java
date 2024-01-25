
package com.it.webservice.onvif.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Dot11StationMode的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <pre>
 * &lt;simpleType name="Dot11StationMode"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Ad-hoc"/&gt;
 *     &lt;enumeration value="Infrastructure"/&gt;
 *     &lt;enumeration value="Extended"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "Dot11StationMode")
@XmlEnum
public enum Dot11StationMode {

    @XmlEnumValue("Ad-hoc")
    AD_HOC("Ad-hoc"),
    @XmlEnumValue("Infrastructure")
    INFRASTRUCTURE("Infrastructure"),
    @XmlEnumValue("Extended")
    EXTENDED("Extended");
    private final String value;

    Dot11StationMode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Dot11StationMode fromValue(String v) {
        for (Dot11StationMode c: Dot11StationMode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
