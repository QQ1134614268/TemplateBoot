
package com.it.sim.webservice.onvif.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ExposurePriority的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <pre>
 * &lt;simpleType name="ExposurePriority"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="LowNoise"/&gt;
 *     &lt;enumeration value="FrameRate"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ExposurePriority")
@XmlEnum
public enum ExposurePriority {

    @XmlEnumValue("LowNoise")
    LOW_NOISE("LowNoise"),
    @XmlEnumValue("FrameRate")
    FRAME_RATE("FrameRate");
    private final String value;

    ExposurePriority(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ExposurePriority fromValue(String v) {
        for (ExposurePriority c: ExposurePriority.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
