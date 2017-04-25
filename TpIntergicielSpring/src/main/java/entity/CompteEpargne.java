package entity;

import java.math.BigDecimal;

import javax.persistence.Entity;

/**
 * Compte épargne.
 */
@Entity
public class CompteEpargne extends Compte {

	public CompteEpargne() {
		super();
	}

	public CompteEpargne(User client, BigDecimal solde) {
		super(client, solde);
	}
}
