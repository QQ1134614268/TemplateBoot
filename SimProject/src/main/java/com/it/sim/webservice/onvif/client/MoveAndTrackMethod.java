
package com.it.sim.webservice.onvif.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>MoveAndTrackMethod的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <pre>
 * &lt;simpleType name="MoveAndTrackMethod"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="PresetToken"/&gt;
 *     &lt;enumeration value="GeoLocation"/&gt;
 *     &lt;enumeration value="PTZVector"/&gt;
 *     &lt;enumeration value="ObjectID"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "MoveAndTrackMethod")
@XmlEnum
public enum MoveAndTrackMethod {

    @XmlEnumValue("PresetToken")
    PRESET_TOKEN("PresetToken"),
    @XmlEnumValue("GeoLocation")
    GEO_LOCATION("GeoLocation"),
    @XmlEnumValue("PTZVector")
    PTZ_VECTOR("PTZVector"),
    @XmlEnumValue("ObjectID")
    OBJECT_ID("ObjectID");
    private final String value;

    MoveAndTrackMethod(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MoveAndTrackMethod fromValue(String v) {
        for (MoveAndTrackMethod c: MoveAndTrackMethod.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
