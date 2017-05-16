
package jordane_quincy.github.com;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour debit complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="debit"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idCompteADebiter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="montant" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "debit", propOrder = {
    "idCompteADebiter",
    "montant"
})
public class Debit {

    protected String idCompteADebiter;
    protected String montant;

    /**
     * Obtient la valeur de la propri�t� idCompteADebiter.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdCompteADebiter() {
        return idCompteADebiter;
    }

    /**
     * D�finit la valeur de la propri�t� idCompteADebiter.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdCompteADebiter(String value) {
        this.idCompteADebiter = value;
    }

    /**
     * Obtient la valeur de la propri�t� montant.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMontant() {
        return montant;
    }

    /**
     * D�finit la valeur de la propri�t� montant.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMontant(String value) {
        this.montant = value;
    }

}
