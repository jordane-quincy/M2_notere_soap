package entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

/**
 * Classe représentant un utilisateur.
 */
@Entity
public class User {

	@Id
	@GeneratedValue
	private long id;
	private String nom;
	private String prenom;
	@OneToMany(mappedBy = "client")
	@OrderBy("id ASC")
	private List<Compte> comptes;

	private String username;
	private String password;

	@Enumerated(EnumType.STRING)
	private Role role;

	public User() {
	}

	public User(String nom, String prenom, String mdp, Role role) {
		this.nom = nom;
		this.prenom = prenom;
		this.username = prenom.substring(0, 1) + nom;
		this.password = mdp;
		this.role = role;
	}

	public long getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (!(o instanceof User)) {
			return false;
		}
		// si deux instances de User partagent le même id, on considère qu'ils
		// sont égaux.
		return id == ((User) o).getId();
	}

}
