package com.github.jordane_quincy;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.jws.WebService;

@WebService(targetNamespace = "http://com.github.jordane_quincy",
endpointInterface = "com.github.jordane_quincy.BankServiceItf",
portName = "BankServiceItf",
serviceName = "BankService"
	)
public class BankServiceImpl implements BankServiceItf {

//	private final static String url = "http://localhost:8080/transfert";
	
	@Override
	public String toPrint(String toPrint) {
		return toPrint;
	}

	@Override
	public String debit(String idCompteADebiter, String montant) {
		String urlParameters =
		        "idCompteADebiter=" + idCompteADebiter +
		        "&idCompteACrediter=" + "1" +
		        "&montant=" + montant;

		return BankServiceImpl.executeGet("http://localhost:8080/transfert", urlParameters);
	}

//	@Override
//	public String remboursement(String idCompteACrediter, String montant) {
//		return null;
//	}

	private static String executeGet(String targetURL, String urlParameters) {
		  HttpURLConnection connection = null;

		  try {
		    //Create connection
		    URL url = new URL(targetURL);
		    connection = (HttpURLConnection) url.openConnection();
		    connection.setRequestMethod("GET");
		    connection.setRequestProperty("Content-Type", 
		        "application/x-www-form-urlencoded");

		    connection.setRequestProperty("Content-Length", 
		        Integer.toString(urlParameters.getBytes().length));

		    connection.setUseCaches(false);
		    connection.setDoOutput(true);

		    //Send request
		    DataOutputStream wr = new DataOutputStream (
		        connection.getOutputStream());
		    wr.writeBytes(urlParameters);
		    wr.close();

		    //Get Response  
		    InputStream is = connection.getInputStream();
		    BufferedReader rd = new BufferedReader(new InputStreamReader(is));
		    StringBuffer response = new StringBuffer();
		    String line;
		    while ((line = rd.readLine()) != null) {
		      response.append(line);
		      response.append('\r');
		    }
		    rd.close();
		    return response.toString();
		  } catch (Exception e) {
		    e.printStackTrace();
		    return null;
		  } finally {
		    if (connection != null) {
		      connection.disconnect();
		    }
		  }
	}
}
