
package com.it.sim.webservice.onvif.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Dot11SignalStrength的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <pre>
 * &lt;simpleType name="Dot11SignalStrength"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="None"/&gt;
 *     &lt;enumeration value="Very Bad"/&gt;
 *     &lt;enumeration value="Bad"/&gt;
 *     &lt;enumeration value="Good"/&gt;
 *     &lt;enumeration value="Very Good"/&gt;
 *     &lt;enumeration value="Extended"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "Dot11SignalStrength")
@XmlEnum
public enum Dot11SignalStrength {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Very Bad")
    VERY_BAD("Very Bad"),
    @XmlEnumValue("Bad")
    BAD("Bad"),
    @XmlEnumValue("Good")
    GOOD("Good"),
    @XmlEnumValue("Very Good")
    VERY_GOOD("Very Good"),
    @XmlEnumValue("Extended")
    EXTENDED("Extended");
    private final String value;

    Dot11SignalStrength(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Dot11SignalStrength fromValue(String v) {
        for (Dot11SignalStrength c: Dot11SignalStrength.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
