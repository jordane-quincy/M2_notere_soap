package service;

import entity.User;

/**
 * Service spécifique d'opération sur les comptes.
 */
public interface OperationCompteService {
	/**
	 * Permet de lancer une opération sur le compte d'un client.
	 *
	 * @param user
	 *            l'utilisateur connecté
	 * @param compteId
	 *            le compte du client
	 * @param typeOperation
	 *            le type d'opération
	 * @param montant
	 *            le montant de l'opération
	 */
	void operationSurCompteClient(User user, String compteId, String typeOperation, String montant);

	void transfert(String compteIdADebiter, String compteIdACreaditer, String montant);
}
