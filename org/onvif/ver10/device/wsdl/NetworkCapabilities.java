
package org.onvif.ver10.device.wsdl;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * <p>NetworkCapabilities complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="NetworkCapabilities">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="IPFilter" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="ZeroConfiguration" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="IPVersion6" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="DynDNS" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Dot11Configuration" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Dot1XConfigurations" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="HostnameFromDHCP" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="NTP" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="DHCPv6" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;anyAttribute processContents='lax'/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NetworkCapabilities")
public class NetworkCapabilities {

    @XmlAttribute(name = "IPFilter")
    protected Boolean ipFilter;
    @XmlAttribute(name = "ZeroConfiguration")
    protected Boolean zeroConfiguration;
    @XmlAttribute(name = "IPVersion6")
    protected Boolean ipVersion6;
    @XmlAttribute(name = "DynDNS")
    protected Boolean dynDNS;
    @XmlAttribute(name = "Dot11Configuration")
    protected Boolean dot11Configuration;
    @XmlAttribute(name = "Dot1XConfigurations")
    protected Integer dot1XConfigurations;
    @XmlAttribute(name = "HostnameFromDHCP")
    protected Boolean hostnameFromDHCP;
    @XmlAttribute(name = "NTP")
    protected Integer ntp;
    @XmlAttribute(name = "DHCPv6")
    protected Boolean dhcPv6;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * ��ȡipFilter���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIPFilter() {
        return ipFilter;
    }

    /**
     * ����ipFilter���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIPFilter(Boolean value) {
        this.ipFilter = value;
    }

    /**
     * ��ȡzeroConfiguration���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isZeroConfiguration() {
        return zeroConfiguration;
    }

    /**
     * ����zeroConfiguration���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setZeroConfiguration(Boolean value) {
        this.zeroConfiguration = value;
    }

    /**
     * ��ȡipVersion6���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIPVersion6() {
        return ipVersion6;
    }

    /**
     * ����ipVersion6���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIPVersion6(Boolean value) {
        this.ipVersion6 = value;
    }

    /**
     * ��ȡdynDNS���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDynDNS() {
        return dynDNS;
    }

    /**
     * ����dynDNS���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDynDNS(Boolean value) {
        this.dynDNS = value;
    }

    /**
     * ��ȡdot11Configuration���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDot11Configuration() {
        return dot11Configuration;
    }

    /**
     * ����dot11Configuration���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDot11Configuration(Boolean value) {
        this.dot11Configuration = value;
    }

    /**
     * ��ȡdot1XConfigurations���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDot1XConfigurations() {
        return dot1XConfigurations;
    }

    /**
     * ����dot1XConfigurations���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDot1XConfigurations(Integer value) {
        this.dot1XConfigurations = value;
    }

    /**
     * ��ȡhostnameFromDHCP���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHostnameFromDHCP() {
        return hostnameFromDHCP;
    }

    /**
     * ����hostnameFromDHCP���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHostnameFromDHCP(Boolean value) {
        this.hostnameFromDHCP = value;
    }

    /**
     * ��ȡntp���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNTP() {
        return ntp;
    }

    /**
     * ����ntp���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNTP(Integer value) {
        this.ntp = value;
    }

    /**
     * ��ȡdhcPv6���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDHCPv6() {
        return dhcPv6;
    }

    /**
     * ����dhcPv6���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDHCPv6(Boolean value) {
        this.dhcPv6 = value;
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
