package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import config.CustomUserDetail;
import entity.User;
import repository.UserRepository;

/**
 * Service gérant la connexion des utilisateurs.
 */
@Service
@Transactional(readOnly = true)
@Qualifier("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	/**
	 * Returns l'objet enveloppe {@link CustomUserDetail} via sa représentation
	 * en bdd via l'entité {@link User} qui est retrouvé en utilisant le
	 * username.
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			// on retrouve l'utilisateur par son username
			User user = userRepository.findByUsername(username);

			// creation de l'enveloppe
			CustomUserDetail customUserDetail = new CustomUserDetail(user);

			return customUserDetail;

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
