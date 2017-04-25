package service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import entity.Compte;
import entity.CompteCourant;
import entity.CompteEpargne;
import entity.Role;
import entity.User;
import repository.CompteRepository;
import repository.UserRepository;

@Service
public class GestionServiceImpl implements GestionService {

	@Autowired
	CompteRepository compteRepository;
	@Autowired
	UserRepository clientRepository;

	@Override
	public List<Compte> getCompteClient(User clientProxy) {
		if (clientProxy != null) {
			User client = clientRepository.findOne(clientProxy.getId());
			if (client != null) {
				return client.getComptes();
			}
		}
		throw new UnsupportedOperationException("Client not found");
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void init() {
		// clean
		compteRepository.delete(compteRepository.findAll());
		clientRepository.delete(clientRepository.findAll());

		// creation d'un administrateur
		User root = new User("R", "oot", "toor", Role.ROLE_ADMIN);
		clientRepository.save(root);

		// creation d'un compte epargne pour l'administrateur
		Compte ceRoot = new CompteEpargne(root, new BigDecimal("300000"));
		compteRepository.save(ceRoot);

		// creation d'un client
		User client = new User("Quincy", "Jordane", "password", Role.ROLE_USER);
		clientRepository.save(client);

		// creation d'un compte courant pour le client
		Compte cc = new CompteCourant(client, new BigDecimal("500"), new BigDecimal("4000"));
		compteRepository.save(cc);

		// creation d'un compte courant pour le client
		Compte ce = new CompteEpargne(client, new BigDecimal("10000"));
		compteRepository.save(ce);
	}

	@Override
	public List<User> findClients() {
		return clientRepository.findByRole(Role.ROLE_USER);
	}
}
