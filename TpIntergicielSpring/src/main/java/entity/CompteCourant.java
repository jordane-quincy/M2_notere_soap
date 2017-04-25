package entity;

import java.math.BigDecimal;

import javax.persistence.Entity;

/**
 * Compte courant (avec découvert autorisé).
 */
@Entity
public class CompteCourant extends Compte {

	private BigDecimal montantDecouvert;

	public CompteCourant() {
		super();
	}

	public CompteCourant(User client, BigDecimal solde, BigDecimal montantDecouvert) {
		super(client, solde);
		this.setMontantDecouvert(montantDecouvert);
	}

	public BigDecimal getMontantDecouvert() {
		return montantDecouvert == null ? BigDecimal.ZERO : montantDecouvert;
	}

	public void setMontantDecouvert(BigDecimal montantDecouvert) {
		this.montantDecouvert = montantDecouvert;
	}
}
