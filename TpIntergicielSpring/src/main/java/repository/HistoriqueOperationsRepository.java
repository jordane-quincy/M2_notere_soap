package repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import entity.HistoriqueOperations;
import entity.User;

/**
 * Gestion des E/S avec la base de donnée pour l'entité
 * {@link HistoriqueOperations}.
 */
@Repository
public interface HistoriqueOperationsRepository extends CrudRepository<HistoriqueOperations, Long> {

	/**
	 * Retrouve la liste de l'historique des operations sur tout les comptes
	 * pour ce client.
	 *
	 * @param client
	 *            le client souhaité
	 * @return l'ensemble de l'historique des operations pour ce client
	 */
	List<HistoriqueOperations> findByClient(User client);
}
