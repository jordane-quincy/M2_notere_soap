package entity;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Classe représentant l'historique des opérations.
 */
@Entity
@XmlRootElement
// @XmlRootElement(name = "HistoriqueOperations")
// @XmlAccessorType(XmlAccessType.FIELD)
public class HistoriqueOperations {

	@Id
	@GeneratedValue
	private long id;

	@ManyToOne
	@JsonIgnore
	private User client;
	@ManyToOne
	private Compte compte;

	@Temporal(TemporalType.DATE)
	private Date dateOperation;

	@Enumerated(EnumType.STRING)
	private Operation operation;

	private BigDecimal montant;

	public HistoriqueOperations() {
	}

	public HistoriqueOperations(User client, Compte compte, Operation operation, BigDecimal montant) {
		super();
		this.client = client;
		this.compte = compte;
		this.dateOperation = Calendar.getInstance().getTime();
		this.operation = operation;
		this.montant = montant;
	}

	public User getClient() {
		return this.client;
	}

	public Compte getCompte() {
		return this.compte;
	}

	public Date getDateOperation() {
		return this.dateOperation;
	}

	public long getId() {
		return this.id;
	}

	public BigDecimal getMontant() {
		return this.montant;
	}

	public Operation getOperation() {
		return this.operation;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

}
