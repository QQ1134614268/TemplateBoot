
package org.onvif.ver10.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>AudioClassType�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * <p>
 * <pre>
 * &lt;simpleType name="AudioClassType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="gun_shot"/>
 *     &lt;enumeration value="scream"/>
 *     &lt;enumeration value="glass_breaking"/>
 *     &lt;enumeration value="tire_screech"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
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
