
package com.it.webservice.onvif.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.wsaddressing.W3CEndpointReference;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/wsn/b-2}ConsumerReference"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/wsn/b-2}Filter" minOccurs="0"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/wsn/b-2}SubscriptionPolicy" minOccurs="0"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/wsn/b-2}CreationTime" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "consumerReference",
    "filter",
    "subscriptionPolicy",
    "creationTime"
})
@XmlRootElement(name = "SubscriptionManagerRP", namespace = "http://docs.oasis-open.org/wsn/b-2")
public class SubscriptionManagerRP {

    @XmlElement(name = "ConsumerReference", namespace = "http://docs.oasis-open.org/wsn/b-2", required = true)
    protected W3CEndpointReference consumerReference;
    @XmlElement(name = "Filter", namespace = "http://docs.oasis-open.org/wsn/b-2")
    protected FilterType filter;
    @XmlElement(name = "SubscriptionPolicy", namespace = "http://docs.oasis-open.org/wsn/b-2")
    protected SubscriptionPolicyType subscriptionPolicy;
    @XmlElement(name = "CreationTime", namespace = "http://docs.oasis-open.org/wsn/b-2")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creationTime;

    /**
     * 获取consumerReference属性的值。
     * 
     * @return
     *     possible object is
     *     {@link W3CEndpointReference }
     *     
     */
    public W3CEndpointReference getConsumerReference() {
        return consumerReference;
    }

    /**
     * 设置consumerReference属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link W3CEndpointReference }
     *     
     */
    public void setConsumerReference(W3CEndpointReference value) {
        this.consumerReference = value;
    }

    /**
     * 获取filter属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FilterType }
     *     
     */
    public FilterType getFilter() {
        return filter;
    }

    /**
     * 设置filter属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FilterType }
     *     
     */
    public void setFilter(FilterType value) {
        this.filter = value;
    }

    /**
     * 获取subscriptionPolicy属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SubscriptionPolicyType }
     *     
     */
    public SubscriptionPolicyType getSubscriptionPolicy() {
        return subscriptionPolicy;
    }

    /**
     * 设置subscriptionPolicy属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SubscriptionPolicyType }
     *     
     */
    public void setSubscriptionPolicy(SubscriptionPolicyType value) {
        this.subscriptionPolicy = value;
    }

    /**
     * 获取creationTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreationTime() {
        return creationTime;
    }

    /**
     * 设置creationTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreationTime(XMLGregorianCalendar value) {
        this.creationTime = value;
    }

}
