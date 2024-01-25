
package com.it.webservice.onvif.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Entity的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <pre>
 * &lt;simpleType name="Entity"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Device"/&gt;
 *     &lt;enumeration value="VideoSource"/&gt;
 *     &lt;enumeration value="AudioSource"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "Entity")
@XmlEnum
public enum Entity {

    @XmlEnumValue("Device")
    DEVICE("Device"),
    @XmlEnumValue("VideoSource")
    VIDEO_SOURCE("VideoSource"),
    @XmlEnumValue("AudioSource")
    AUDIO_SOURCE("AudioSource");
    private final String value;

    Entity(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Entity fromValue(String v) {
        for (Entity c: Entity.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
