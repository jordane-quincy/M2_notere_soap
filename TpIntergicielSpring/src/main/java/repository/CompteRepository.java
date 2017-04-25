package repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import entity.Compte;

/**
 * Gestion des E/S avec la base de donnée pour l'entité {@link Compte}.
 */
@Repository
public interface CompteRepository extends CrudRepository<Compte, Long> {
	// Aucun besoin de méthode particulière ici pour le moment.
}
