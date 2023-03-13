
package org.onvif.ver10.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ImageSendingType的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="ImageSendingType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Embedded"/>
 *     &lt;enumeration value="LocalStorage"/>
 *     &lt;enumeration value="RemoteStorage"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ImageSendingType")
@XmlEnum
public enum ImageSendingType {

    @XmlEnumValue("Embedded")
    EMBEDDED("Embedded"),
    @XmlEnumValue("LocalStorage")
    LOCAL_STORAGE("LocalStorage"),
    @XmlEnumValue("RemoteStorage")
    REMOTE_STORAGE("RemoteStorage");
    private final String value;

    ImageSendingType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ImageSendingType fromValue(String v) {
        for (ImageSendingType c: ImageSendingType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
