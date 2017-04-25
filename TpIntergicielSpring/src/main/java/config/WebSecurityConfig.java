package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Classe de configuration de lal sécurité.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("customUserDetailsService")
	UserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests() //
				// les pages d'acceuil et d'initialisation de la base de données
				// sont accessible à tous (connecté ou non)
				.antMatchers("/", "/init").permitAll() //
				// la page d'administration n'est que pour les utilisateurs
				// ayant le role ADMIN
				.antMatchers("/admin").hasRole("ADMIN") //
				.and() // configuration de la connexion
				.formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password").permitAll() //
				.and() // configuration de la déconnexion
				.logout().logoutSuccessUrl("/login?logout").permitAll();
	}

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
}
