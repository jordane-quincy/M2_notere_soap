
package client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the client package. 
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
@XmlRegistry
public class ObjectFactory {

    private final static QName _ToPrint_QNAME = new QName("http://com.github.jordane_quincy", "toPrint");
    private final static QName _ToPrintResponse_QNAME = new QName("http://com.github.jordane_quincy", "toPrintResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ToPrint }
     * 
     */
    public ToPrint createToPrint() {
        return new ToPrint();
    }

    /**
     * Create an instance of {@link ToPrintResponse }
     * 
     */
    public ToPrintResponse createToPrintResponse() {
        return new ToPrintResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ToPrint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com.github.jordane_quincy", name = "toPrint")
    public JAXBElement<ToPrint> createToPrint(ToPrint value) {
        return new JAXBElement<ToPrint>(_ToPrint_QNAME, ToPrint.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ToPrintResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com.github.jordane_quincy", name = "toPrintResponse")
    public JAXBElement<ToPrintResponse> createToPrintResponse(ToPrintResponse value) {
        return new JAXBElement<ToPrintResponse>(_ToPrintResponse_QNAME, ToPrintResponse.class, null, value);
    }

}