
package com.it.webservice.onvif.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Duplex的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <pre>
 * &lt;simpleType name="Duplex"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Full"/&gt;
 *     &lt;enumeration value="Half"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "Duplex")
@XmlEnum
public enum Duplex {

    @XmlEnumValue("Full")
    FULL("Full"),
    @XmlEnumValue("Half")
    HALF("Half");
    private final String value;

    Duplex(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Duplex fromValue(String v) {
        for (Duplex c: Duplex.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
