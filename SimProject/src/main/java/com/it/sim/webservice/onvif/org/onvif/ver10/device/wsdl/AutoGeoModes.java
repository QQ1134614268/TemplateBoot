
package org.onvif.ver10.device.wsdl;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>AutoGeoModes的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="AutoGeoModes">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Location"/>
 *     &lt;enumeration value="Heading"/>
 *     &lt;enumeration value="Leveling"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AutoGeoModes")
@XmlEnum
public enum AutoGeoModes {


    /**
     * Automatic adjustment of the device location.
     * 
     */
    @XmlEnumValue("Location")
    LOCATION("Location"),

    /**
     * Automatic adjustment of the device orientation relative to the compass
     *                                 also called yaw.
     *                             
     * 
     */
    @XmlEnumValue("Heading")
    HEADING("Heading"),

    /**
     * Automatic adjustment of the deviation from the horizon also called pitch
     *                                 and roll.
     *                             
     * 
     */
    @XmlEnumValue("Leveling")
    LEVELING("Leveling");
    private final String value;

    AutoGeoModes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AutoGeoModes fromValue(String v) {
        for (AutoGeoModes c: AutoGeoModes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
