package run;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "RetourWS")
@XmlAccessorType(XmlAccessType.FIELD)
public class RetourWS {

	String idCompteDebite;
	String idCompteCredite;
	String typeOperation;
	String montant;

	public RetourWS() {
		// avoid : run.RetourWS ne comporte aucun constructeur sans argument par
		// d&eacute;faut.
		super();
	}

	public RetourWS(String idCompteDebite, String idCompteCredite, String typeOperation, String montant) {
		super();
		this.idCompteDebite = idCompteDebite;
		this.idCompteCredite = idCompteCredite;
		this.typeOperation = typeOperation;
		this.montant = montant;
	}

	public String getIdCompteDebite() {
		return this.idCompteDebite;
	}

	public String getIdCompteCredite() {
		return this.idCompteCredite;
	}

	public String getTypeOperation() {
		return this.typeOperation;
	}

	public String getMontant() {
		return this.montant;
	}

	@Override
	public String toString() {
		return "RetourWS [idCompteDebite=" + this.idCompteDebite + ", idCompteCredite=" + this.idCompteCredite
				+ ", typeOperation=" + this.typeOperation + ", montant=" + this.montant + "]";
	}

}
