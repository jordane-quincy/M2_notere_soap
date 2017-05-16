package com.github.jordane_quincy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.jws.WebService;

@WebService(targetNamespace = "http://com.github.jordane_quincy", endpointInterface = "com.github.jordane_quincy.BankServiceItf", portName = "BankServiceItf", serviceName = "BankService")
public class BankServiceImpl implements BankServiceItf {

	private final static String BASE_URL = "http://localhost:8080/transfert";

	@Override
	public String toPrint(String toPrint) {
		return toPrint;
	}

	@Override
	public String debit(String idCompteADebiter, String montant) {
		String urlParameters = "?idCompteADebiter=" + idCompteADebiter + "&idCompteACrediter=" + "1" + "&montant="
				+ montant;

		return BankServiceImpl.executeGet(BASE_URL + urlParameters);
	}

	@Override
	public String remboursement(String idCompteACrediter, String montant) {
		String urlParameters = "?idCompteADebiter=" + "1" + "&idCompteACrediter=" + idCompteACrediter + "&montant="
				+ montant;

		return BankServiceImpl.executeGet(BASE_URL + urlParameters);
	}

	private static String executeGet(String targetURL) {
		String retour = "";

		HttpURLConnection con = null;
		try {
			URL obj = new URL(targetURL);

			con = (HttpURLConnection) obj.openConnection();

			// optional default is GET
			con.setRequestMethod("GET");

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + targetURL);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			retour = response.toString();

		} catch (Exception e) {
			// FIXME : Pokémon exception : catch them all
			e.printStackTrace();
		} finally {
			if (con != null) {
				con.disconnect();
			}
		}

		return retour;

	}
}
