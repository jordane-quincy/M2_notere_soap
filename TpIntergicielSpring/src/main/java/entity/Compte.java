package entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Classe abstraite représentant un compte.
 */
@Entity
public abstract class Compte {

	@Id
	@GeneratedValue
	private long id;
	@ManyToOne
	@JsonIgnore
	private User client;
	@JsonIgnore
	private BigDecimal solde;

	public Compte() {
		super();
	}

	public Compte(User client) {
		// appel a l'autre constructeur
		this(client, null);
	}

	public Compte(User client, BigDecimal solde) {
		super();
		this.client = client;
		this.solde = solde == null ? BigDecimal.ZERO : solde;
	}

	public long getId() {
		return this.id;
	}

	public BigDecimal getSolde() {
		return this.solde;
	}

	public void setSolde(BigDecimal solde) {
		this.solde = solde;
	}

	public BigDecimal credit(BigDecimal montantACrediter) {
		setSolde(this.solde.add(montantACrediter));
		return this.solde;
	}

	public User getClient() {
		return this.client;
	}
}
