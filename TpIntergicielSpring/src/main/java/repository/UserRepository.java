package repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import entity.Role;
import entity.User;

/**
 * Gestion des E/S avec la base de donnée pour l'entité {@link User}.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	/**
	 * Retrouve une utilisateur via le champ username.
	 *
	 * @param username
	 *            le nom d'utilisateur
	 * @return l'utilisateur
	 */
	User findByUsername(String username);

	/**
	 * Retrouve la liste des utilisateurs ayant un certain rôle.
	 *
	 * @param role
	 *            le rôle souhaité
	 * @return l'ensemble des utilisateurs ayant ce rôle
	 */
	List<User> findByRole(Role role);
}
