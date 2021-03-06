package run;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import entity.HistoriqueOperations;
import entity.User;
import repository.HistoriqueOperationsRepository;
import repository.UserRepository;
import service.OperationCompteService;

@RestController
public class WsController {

	private static String TRANSFERT = "transfert";

	@Autowired
	private OperationCompteService operationCompteService;

	@Autowired
	private HistoriqueOperationsRepository historiqueOperationsRepository;

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/transfert", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
	public RetourWS transfert(@RequestParam(value = "idCompteADebiter") String idCompteADebiter,
			@RequestParam(value = "idCompteACrediter") String idCompteACrediter,
			@RequestParam(value = "montant") String montant) {

		this.operationCompteService.transfert(idCompteADebiter, idCompteACrediter, montant);

		return new RetourWS(idCompteADebiter, idCompteACrediter, WsController.TRANSFERT, montant);
	}

	@RequestMapping(value = "/infos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<HistoriqueOperations> infos(@RequestParam(value = "username") String username) {

		List<HistoriqueOperations> lstHistoriqueOperations = new ArrayList<>();

		User client = this.userRepository.findByUsername(username);
		if (client != null) {
			List<HistoriqueOperations> lstHistorique = this.historiqueOperationsRepository.findByClient(client);

			lstHistoriqueOperations.addAll(lstHistorique);
		}

		return lstHistoriqueOperations;
	}
}