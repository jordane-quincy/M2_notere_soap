package com.github.jordane_quincy;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "http://com.github.jordane_quincy", name = "BankServiceItf")
public interface BankServiceItf {

	String toPrint(@WebParam(name = "toPrint") String toPrint);

	String debit(@WebParam(name = "idCompteADebiter") String idCompteADebiter,
			@WebParam(name = "montant") String montant);

	String remboursement(@WebParam(name = "idCompteACrediter") String idCompteACrediter,
			@WebParam(name = "montant") String montant);
}
