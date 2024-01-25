
package com.it.webservice.onvif.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>WhiteBalanceMode的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <pre>
 * &lt;simpleType name="WhiteBalanceMode"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="AUTO"/&gt;
 *     &lt;enumeration value="MANUAL"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "WhiteBalanceMode")
@XmlEnum
public enum WhiteBalanceMode {

    AUTO,
    MANUAL;

    public String value() {
        return name();
    }

    public static WhiteBalanceMode fromValue(String v) {
        return valueOf(v);
    }

}
