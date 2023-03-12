
package org.onvif.ver10.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>AudioEncodingMimeNames�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * <p>
 * <pre>
 * &lt;simpleType name="AudioEncodingMimeNames">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PCMU"/>
 *     &lt;enumeration value="G726"/>
 *     &lt;enumeration value="MP4A-LATM"/>
 *     &lt;enumeration value="mpeg4-generic"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AudioEncodingMimeNames")
@XmlEnum
public enum AudioEncodingMimeNames {

    PCMU("PCMU"),

    /**
     * AudioEncodingMimeName G726 is used to represent G726-16,G726-24,G726-32 and
     *                         G726-40 defined in the IANA Media Types
     *                     
     * 
     */
    @XmlEnumValue("G726")
    G_726("G726"),
    @XmlEnumValue("MP4A-LATM")
    MP_4_A_LATM("MP4A-LATM"),
    @XmlEnumValue("mpeg4-generic")
    MPEG_4_GENERIC("mpeg4-generic");
    private final String value;

    AudioEncodingMimeNames(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AudioEncodingMimeNames fromValue(String v) {
        for (AudioEncodingMimeNames c: AudioEncodingMimeNames.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
