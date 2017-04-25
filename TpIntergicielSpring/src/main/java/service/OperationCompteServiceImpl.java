package service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import entity.Compte;
import entity.CompteCourant;
import entity.HistoriqueOperations;
import entity.Operation;
import entity.User;
import groovy.lang.Singleton;
import repository.CompteRepository;
import repository.HistoriqueOperationsRepository;
import repository.UserRepository;

@Service
@Singleton
public class OperationCompteServiceImpl implements OperationCompteService {

	@Autowired
	CompteRepository compteRepository;
	@Autowired
	UserRepository clientRepository;
	@Autowired
	HistoriqueOperationsRepository historiqueOperationsRepository;

	@Transactional(propagation = Propagation.REQUIRED)
	private BigDecimal credit(User user, Long idCompte, BigDecimal montantACrediter) {
		final Compte compte = this.compteRepository.findOne(idCompte);
		// il s'agit bien du compte du client
		if (user.equals(compte.getClient()) && montantACrediter != null && compte != null) {
			compte.credit(montantACrediter);

			this.compteRepository.save(compte);
		}
		return compte.getSolde();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private BigDecimal debit(User user, Long idCompte, BigDecimal montantADebiter) {
		final Compte compte = this.compteRepository.findOne(idCompte);
		// il s'agit bien du compte du client
		if (user.equals(compte.getClient()) && montantADebiter != null && compte != null) {
			final BigDecimal solde = compte.getSolde();

			// pour un compte d'epargne, le solde doit être supérieur au montant
			// à débiter
			// alors qu'un compte courant dispose en plus d'un découvert
			// autorisé
			if (solde.compareTo(montantADebiter) >= 0 || compte instanceof CompteCourant
					&& solde.add(((CompteCourant) compte).getMontantDecouvert()).compareTo(montantADebiter) >= 0) {
				// on a assez sur le compte
				compte.setSolde(solde.subtract(montantADebiter));

				this.compteRepository.save(compte);
			}
		}
		return compte.getSolde();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private BigDecimal obtenirPret(User user, Long idCompte, BigDecimal montantDuPret) {
		final Compte compte = this.compteRepository.findOne(idCompte);
		BigDecimal nouveauSolde = null;
		if (montantDuPret != null && compte != null) {
			// Prêt : crédit accordé uniquement si le solde est positif
			if (BigDecimal.ZERO.compareTo(compte.getSolde()) <= 0) {
				// on n'est pas a decouvert
				nouveauSolde = this.credit(user, idCompte, montantDuPret);
			}
		}
		return nouveauSolde;
	}

	@Override
	public void operationSurCompteClient(User user, String compteId, String typeOperation, String montant) {
		if (montant == null) {
			throw new UnsupportedOperationException("Pas de montant");
		}
		if (user == null) {
			throw new UnsupportedOperationException("Client not found");
		}

		final BigDecimal montantOperation = new BigDecimal(montant);
		final Long idCompte = Long.parseLong(compteId);
		if ("credit".equalsIgnoreCase(typeOperation)) {
			this.credit(user, idCompte, montantOperation);
		} else if ("debit".equalsIgnoreCase(typeOperation)) {
			this.debit(user, idCompte, montantOperation);
		} else if ("pret".equalsIgnoreCase(typeOperation)) {
			this.obtenirPret(user, idCompte, montantOperation);
		}

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void transfert(String compteIdADebiter, String compteIdACrediter, String montantString) {
		final Compte compteADebiter = this.compteRepository.findOne(Long.parseLong(compteIdADebiter));
		final Compte compteACrediter = this.compteRepository.findOne(Long.parseLong(compteIdACrediter));

		final BigDecimal montant = new BigDecimal(montantString);

		final BigDecimal soldeCompteADebiter = compteADebiter.getSolde();
		if (soldeCompteADebiter.compareTo(montant) >= 0
				|| compteADebiter instanceof CompteCourant && soldeCompteADebiter
						.add(((CompteCourant) compteADebiter).getMontantDecouvert()).compareTo(montant) >= 0) {
			// le compte a debiter est ok

			// debit
			compteADebiter.setSolde(compteADebiter.getSolde().subtract(montant));
			this.compteRepository.save(compteADebiter);
			// sauvegarde de l'operation
			// TODO: utiliser un trigger pourrait être avantageux...
			final HistoriqueOperations historiqueDebit = new HistoriqueOperations(compteADebiter.getClient(),
					compteADebiter, Operation.DEBIT, montant);
			this.historiqueOperationsRepository.save(historiqueDebit);

			// credit
			compteACrediter.setSolde(compteACrediter.getSolde().add(montant));
			this.compteRepository.save(compteACrediter);
			// sauvegarde de l'operation
			// TODO: utiliser un trigger pourrait être avantageux...
			final HistoriqueOperations historiqueCredit = new HistoriqueOperations(compteACrediter.getClient(),
					compteACrediter, Operation.CREDIT, montant);
			this.historiqueOperationsRepository.save(historiqueCredit);

		} else {
			// le compte a debiter est ko
			// TODO : lever une exception ?
		}
	}
}
