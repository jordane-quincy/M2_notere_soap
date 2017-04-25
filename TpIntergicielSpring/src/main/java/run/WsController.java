package run;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import service.OperationCompteService;

@RestController
public class WsController {

	private static String TRANSFERT = "transfert";

	@Autowired
	OperationCompteService operationCompteService;

    @RequestMapping(value="/transfert", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public RetourWS transfert(@RequestParam(value="idCompteADebiter") String idCompteADebiter,
    		@RequestParam(value="idCompteACrediter") String idCompteACrediter,
    		@RequestParam(value="montant") String montant) {
    	
    	operationCompteService.transfert(idCompteADebiter, idCompteACrediter, montant);
    	
        return new RetourWS(idCompteADebiter, idCompteACrediter, WsController.TRANSFERT, montant);
    }
}