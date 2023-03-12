
package org.onvif.ver10.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>MoveAndTrackMethod的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="MoveAndTrackMethod">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PresetToken"/>
 *     &lt;enumeration value="GeoLocation"/>
 *     &lt;enumeration value="PTZVector"/>
 *     &lt;enumeration value="ObjectID"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
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
