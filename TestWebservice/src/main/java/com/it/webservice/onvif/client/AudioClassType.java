
package com.it.webservice.onvif.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>AudioClassType的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <pre>
 * &lt;simpleType name="AudioClassType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="gun_shot"/&gt;
 *     &lt;enumeration value="scream"/&gt;
 *     &lt;enumeration value="glass_breaking"/&gt;
 *     &lt;enumeration value="tire_screech"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "AudioClassType")
@XmlEnum
public enum AudioClassType {

    @XmlEnumValue("gun_shot")
    GUN_SHOT("gun_shot"),
    @XmlEnumValue("scream")
    SCREAM("scream"),
    @XmlEnumValue("glass_breaking")
    GLASS_BREAKING("glass_breaking"),
    @XmlEnumValue("tire_screech")
    TIRE_SCREECH("tire_screech");
    private final String value;

    AudioClassType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AudioClassType fromValue(String v) {
        for (AudioClassType c: AudioClassType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
