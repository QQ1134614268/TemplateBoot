
package com.it.webservice.onvif.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>RelayIdleState的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <pre>
 * &lt;simpleType name="RelayIdleState"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="closed"/&gt;
 *     &lt;enumeration value="open"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "RelayIdleState")
@XmlEnum
public enum RelayIdleState {

    @XmlEnumValue("closed")
    CLOSED("closed"),
    @XmlEnumValue("open")
    OPEN("open");
    private final String value;

    RelayIdleState(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RelayIdleState fromValue(String v) {
        for (RelayIdleState c: RelayIdleState.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
