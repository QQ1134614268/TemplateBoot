
package com.it.sim.webservice.onvif.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>AudioEncoding的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <pre>
 * &lt;simpleType name="AudioEncoding"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="G711"/&gt;
 *     &lt;enumeration value="G726"/&gt;
 *     &lt;enumeration value="AAC"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "AudioEncoding")
@XmlEnum
public enum AudioEncoding {

    @XmlEnumValue("G711")
    G_711("G711"),
    @XmlEnumValue("G726")
    G_726("G726"),
    AAC("AAC");
    private final String value;

    AudioEncoding(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AudioEncoding fromValue(String v) {
        for (AudioEncoding c: AudioEncoding.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
