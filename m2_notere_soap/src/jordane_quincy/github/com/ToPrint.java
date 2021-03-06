
package jordane_quincy.github.com;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour toPrint complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="toPrint"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="toPrint" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "toPrint", propOrder = {
    "toPrint"
})
public class ToPrint {

    protected String toPrint;

    /**
     * Obtient la valeur de la propri�t� toPrint.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToPrint() {
        return toPrint;
    }

    /**
     * D�finit la valeur de la propri�t� toPrint.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToPrint(String value) {
        this.toPrint = value;
    }

}
