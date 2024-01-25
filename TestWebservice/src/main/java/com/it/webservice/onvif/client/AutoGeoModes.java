
package com.it.webservice.onvif.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>AutoGeoModes的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <pre>
 * &lt;simpleType name="AutoGeoModes"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Location"/&gt;
 *     &lt;enumeration value="Heading"/&gt;
 *     &lt;enumeration value="Leveling"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "AutoGeoModes", namespace = "http://www.onvif.org/ver10/device/wsdl")
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
