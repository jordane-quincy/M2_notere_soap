
package jordane_quincy.github.com;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jordane_quincy.github.com package. 
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

    private final static QName _Debit_QNAME = new QName("http://com.github.jordane_quincy", "debit");
    private final static QName _DebitResponse_QNAME = new QName("http://com.github.jordane_quincy", "debitResponse");
    private final static QName _Remboursement_QNAME = new QName("http://com.github.jordane_quincy", "remboursement");
    private final static QName _RemboursementResponse_QNAME = new QName("http://com.github.jordane_quincy", "remboursementResponse");
    private final static QName _ToPrint_QNAME = new QName("http://com.github.jordane_quincy", "toPrint");
    private final static QName _ToPrintResponse_QNAME = new QName("http://com.github.jordane_quincy", "toPrintResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jordane_quincy.github.com
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Debit }
     * 
     */
    public Debit createDebit() {
        return new Debit();
    }

    /**
     * Create an instance of {@link DebitResponse }
     * 
     */
    public DebitResponse createDebitResponse() {
        return new DebitResponse();
    }

    /**
     * Create an instance of {@link Remboursement }
     * 
     */
    public Remboursement createRemboursement() {
        return new Remboursement();
    }

    /**
     * Create an instance of {@link RemboursementResponse }
     * 
     */
    public RemboursementResponse createRemboursementResponse() {
        return new RemboursementResponse();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Debit }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com.github.jordane_quincy", name = "debit")
    public JAXBElement<Debit> createDebit(Debit value) {
        return new JAXBElement<Debit>(_Debit_QNAME, Debit.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DebitResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com.github.jordane_quincy", name = "debitResponse")
    public JAXBElement<DebitResponse> createDebitResponse(DebitResponse value) {
        return new JAXBElement<DebitResponse>(_DebitResponse_QNAME, DebitResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Remboursement }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com.github.jordane_quincy", name = "remboursement")
    public JAXBElement<Remboursement> createRemboursement(Remboursement value) {
        return new JAXBElement<Remboursement>(_Remboursement_QNAME, Remboursement.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemboursementResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com.github.jordane_quincy", name = "remboursementResponse")
    public JAXBElement<RemboursementResponse> createRemboursementResponse(RemboursementResponse value) {
        return new JAXBElement<RemboursementResponse>(_RemboursementResponse_QNAME, RemboursementResponse.class, null, value);
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
