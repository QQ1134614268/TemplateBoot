
package com.it.sim.webservice.jdk.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>addResponse complex type的 Java 类。
 *
 * <p>以下模式片段指定包含在此类中的预期内容。
 *
 * <pre>
 * &lt;complexType name="addResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{<a href="http://www.w3.org/2001/XMLSchema">...</a>}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{<a href="http://www.w3.org/2001/XMLSchema">...</a>}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addResponse", propOrder = {
    "_return"
})
public class AddResponse {

    @XmlElement(name = "return")
    protected int _return;

    /**
     * 获取return属性的值。
     * 
     */
    public int getReturn() {
        return _return;
    }

    /**
     * 设置return属性的值。
     * 
     */
    public void setReturn(int value) {
        this._return = value;
    }

}
