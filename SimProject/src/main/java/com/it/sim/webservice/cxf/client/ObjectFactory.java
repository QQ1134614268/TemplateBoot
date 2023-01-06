
package com.it.sim.webservice.cxf.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.it.sim.webservice.cxf.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@SuppressWarnings({"SpellCheckingInspection","HttpUrlsUsage"})
@XmlRegistry
public class ObjectFactory {

    private final static QName _SayX_QNAME = new QName("http://service.cxf.webservice.sim.it.com/", "sayX");
    private final static QName _SayXResponse_QNAME = new QName("http://service.cxf.webservice.sim.it.com/", "sayXResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.it.sim.webservice.cxf.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SayX }
     * 
     */
    public SayX createSayX() {
        return new SayX();
    }

    /**
     * Create an instance of {@link SayXResponse }
     * 
     */
    public SayXResponse createSayXResponse() {
        return new SayXResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayX }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SayX }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.cxf.webservice.sim.it.com/", name = "sayX")
    public JAXBElement<SayX> createSayX(SayX value) {
        return new JAXBElement<>(_SayX_QNAME, SayX.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayXResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SayXResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.cxf.webservice.sim.it.com/", name = "sayXResponse")
    public JAXBElement<SayXResponse> createSayXResponse(SayXResponse value) {
        return new JAXBElement<>(_SayXResponse_QNAME, SayXResponse.class, null, value);
    }

}
