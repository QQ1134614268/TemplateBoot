
package com.it.sim.webservice.onvif.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>StreamType的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <pre>
 * &lt;simpleType name="StreamType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="RTP-Unicast"/&gt;
 *     &lt;enumeration value="RTP-Multicast"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "StreamType")
@XmlEnum
public enum StreamType {

    @XmlEnumValue("RTP-Unicast")
    RTP_UNICAST("RTP-Unicast"),
    @XmlEnumValue("RTP-Multicast")
    RTP_MULTICAST("RTP-Multicast");
    private final String value;

    StreamType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static StreamType fromValue(String v) {
        for (StreamType c: StreamType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
