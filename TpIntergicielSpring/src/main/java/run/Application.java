package run;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import config.DatabaseConfig;
import entity.Compte;
import entity.CompteCourant;
import entity.CompteEpargne;
import entity.Role;
import entity.User;
import repository.CompteRepository;
import repository.UserRepository;
import service.GestionService;

/**
 * Classe principale lançant l'application.
 */
@SpringBootApplication
@ComponentScan(basePackageClasses = { UserRepository.class, GestionService.class, DatabaseConfig.class,
		UniqueController.class, WsController.class })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	CompteRepository compteRepository;

	@Autowired
	UserRepository clientRepository;

	@PostConstruct
	@Transactional(propagation = Propagation.REQUIRED)
	private void postConstruct() {
		// clean
		this.compteRepository.delete(this.compteRepository.findAll());
		this.clientRepository.delete(this.clientRepository.findAll());

		// creation d'un administrateur
		final User root = new User("R", "oot", "toor", Role.ROLE_ADMIN);
		this.clientRepository.save(root);

		// creation d'un compte epargne pour l'administrateur
		final Compte ceRoot = new CompteEpargne(root, new BigDecimal("300000"));
		this.compteRepository.save(ceRoot);

		// creation d'un client
		final User client = new User("Quincy", "Jordane", "password", Role.ROLE_USER);
		this.clientRepository.save(client);

		// creation d'un compte courant pour le client
		final Compte cc = new CompteCourant(client, new BigDecimal("500"), new BigDecimal("4000"));
		this.compteRepository.save(cc);

		// creation d'un compte courant pour le client
		final Compte ce = new CompteEpargne(client, new BigDecimal("10000"));
		this.compteRepository.save(ce);
	}

}