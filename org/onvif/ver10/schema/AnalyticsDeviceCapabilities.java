
package org.onvif.ver10.schema;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * <p>AnalyticsDeviceCapabilities complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="AnalyticsDeviceCapabilities">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="XAddr" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *         &lt;element name="RuleSupport" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Extension" type="{http://www.onvif.org/ver10/schema}AnalyticsDeviceExtension" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;anyAttribute processContents='lax'/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AnalyticsDeviceCapabilities", propOrder = {
    "xAddr",
    "ruleSupport",
    "extension"
})
public class AnalyticsDeviceCapabilities {

    @XmlElement(name = "XAddr", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String xAddr;
    @XmlElement(name = "RuleSupport")
    protected Boolean ruleSupport;
    @XmlElement(name = "Extension")
    protected AnalyticsDeviceExtension extension;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * ��ȡxAddr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXAddr() {
        return xAddr;
    }

    /**
     * ����xAddr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXAddr(String value) {
        this.xAddr = value;
    }

    /**
     * ��ȡruleSupport���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRuleSupport() {
        return ruleSupport;
    }

    /**
     * ����ruleSupport���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRuleSupport(Boolean value) {
        this.ruleSupport = value;
    }

    /**
     * ��ȡextension���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link AnalyticsDeviceExtension }
     *     
     */
    public AnalyticsDeviceExtension getExtension() {
        return extension;
    }

    /**
     * ����extension���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link AnalyticsDeviceExtension }
     *     
     */
    public void setExtension(AnalyticsDeviceExtension value) {
        this.extension = value;
    }

    /**
     * Gets a map that contains attributes that aren't bound to any typed property on this class.
     * 
     * <p>
     * the map is keyed by the name of the attribute and 
     * the value is the string value of the attribute.
     * 
     * the map returned by this method is live, and you can add new attribute
     * by updating the map directly. Because of this design, there's no setter.
     * 
     * 
     * @return
     *     always non-null
     */
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

}
