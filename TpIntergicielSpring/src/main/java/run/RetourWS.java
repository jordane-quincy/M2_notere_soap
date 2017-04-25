package run;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="retourWS")
public class RetourWS {
	
	private final String idCompteDebite;
	private final String idCompteCredite;
	private final String typeOperation;
    private final String montant;
    
    public RetourWS(String idCompteDebite, String idCompteCredite, String typeOperation, String montant) {
		super();
		this.idCompteDebite = idCompteDebite;
		this.idCompteCredite = idCompteCredite;
		this.typeOperation = typeOperation;
		this.montant = montant;
	}

	public String getIdCompteDebite() {
		return idCompteDebite;
	}

	public String getIdCompteCredite() {
		return idCompteCredite;
	}

	public String getTypeOperation() {
		return typeOperation;
	}

	public String getMontant() {
		return montant;
	}

}