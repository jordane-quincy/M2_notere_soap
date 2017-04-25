package config;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import entity.User;

/**
 * Classe de gestion des droits des utilisateurs.
 */
public class CustomUserDetail implements UserDetails {

	private static final long serialVersionUID = -1816286427799062668L;

	/**
	 * L'utilisateur enregistré.
	 */
	private User user;

	/**
	 * Liste des droits accordés à l'utilisateur. Pour le moment, cette liste ne
	 * compte qu'un élément.
	 */
	private List<SimpleGrantedAuthority> auhorities = new LinkedList<>();

	public CustomUserDetail(User user) {
		super();
		this.user = user;
		auhorities.add(new SimpleGrantedAuthority(user.getRole().toString()));
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	public User getUser() {
		return user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return auhorities;
	}
}
