
package com.it.webservice.onvif.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>VideoEncoding的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <pre>
 * &lt;simpleType name="VideoEncoding"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="JPEG"/&gt;
 *     &lt;enumeration value="MPEG4"/&gt;
 *     &lt;enumeration value="H264"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "VideoEncoding")
@XmlEnum
public enum VideoEncoding {

    JPEG("JPEG"),
    @XmlEnumValue("MPEG4")
    MPEG_4("MPEG4"),
    @XmlEnumValue("H264")
    H_264("H264");
    private final String value;

    VideoEncoding(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VideoEncoding fromValue(String v) {
        for (VideoEncoding c: VideoEncoding.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
