package service;

import java.util.List;

import entity.Compte;
import entity.User;

/**
 * Service fournit par l'application.
 */
public interface GestionService {

	/**
	 * Retrouve les comptes d'un client.
	 *
	 * @param client
	 *            le client
	 * @return l'ensemble de ses comptes.
	 */
	List<Compte> getCompteClient(User client);

	/**
	 * Lance l'initialisation de la base de données.
	 */
	void init();

	/**
	 * Retrouve les clients.
	 *
	 * @return l'ensemble des clients (utilisateurs avec le role USER)
	 */
	List<User> findClients();

}
