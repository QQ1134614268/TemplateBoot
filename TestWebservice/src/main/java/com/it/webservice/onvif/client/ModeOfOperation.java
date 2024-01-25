
package com.it.webservice.onvif.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ModeOfOperation的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <pre>
 * &lt;simpleType name="ModeOfOperation"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Idle"/&gt;
 *     &lt;enumeration value="Active"/&gt;
 *     &lt;enumeration value="Unknown"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ModeOfOperation")
@XmlEnum
public enum ModeOfOperation {

    @XmlEnumValue("Idle")
    IDLE("Idle"),
    @XmlEnumValue("Active")
    ACTIVE("Active"),

    /**
     * This case should never happen.
     * 
     */
    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown");
    private final String value;

    ModeOfOperation(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ModeOfOperation fromValue(String v) {
        for (ModeOfOperation c: ModeOfOperation.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
