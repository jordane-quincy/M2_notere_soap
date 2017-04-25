package entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Classe abstraite représentant un compte.
 */
@Entity
public abstract class Compte {

	@Id
	@GeneratedValue
	private long id;
	@ManyToOne
	private User client;
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
		return id;
	}

	public BigDecimal getSolde() {
		return solde;
	}

	public void setSolde(BigDecimal solde) {
		this.solde = solde;
	}

	public BigDecimal credit(BigDecimal montantACrediter) {
		setSolde(solde.add(montantACrediter));
		return solde;
	}

	public User getClient() {
		return client;
	}
}
