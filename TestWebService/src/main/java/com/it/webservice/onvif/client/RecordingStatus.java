
package com.it.webservice.onvif.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>RecordingStatus的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <pre>
 * &lt;simpleType name="RecordingStatus"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Initiated"/&gt;
 *     &lt;enumeration value="Recording"/&gt;
 *     &lt;enumeration value="Stopped"/&gt;
 *     &lt;enumeration value="Removing"/&gt;
 *     &lt;enumeration value="Removed"/&gt;
 *     &lt;enumeration value="Unknown"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "RecordingStatus")
@XmlEnum
public enum RecordingStatus {

    @XmlEnumValue("Initiated")
    INITIATED("Initiated"),
    @XmlEnumValue("Recording")
    RECORDING("Recording"),
    @XmlEnumValue("Stopped")
    STOPPED("Stopped"),
    @XmlEnumValue("Removing")
    REMOVING("Removing"),
    @XmlEnumValue("Removed")
    REMOVED("Removed"),

    /**
     * This case should never happen.
     * 
     */
    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown");
    private final String value;

    RecordingStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RecordingStatus fromValue(String v) {
        for (RecordingStatus c: RecordingStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
