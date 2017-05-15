package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.eclipse.persistence.jaxb.JAXBContextFactory;
import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;

import run.RetourWS;

public class MainXml {

	public static void main(String[] args) throws JAXBException, IOException {
		String uri = "http://localhost:8080/transfert?idCompteADebiter=3&idCompteACrediter=1&montant=2";
		URL url = new URL(uri);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod(RequestMethod.GET.name());
		connection.setRequestProperty("Accept", MediaType.APPLICATION_XML_VALUE);

		InputStream is = connection.getInputStream();
		BufferedReader rd = new BufferedReader(new InputStreamReader(is));
		StringBuffer response = new StringBuffer();
		String line;
		while ((line = rd.readLine()) != null) {
			response.append(line).append('\r');
		}
		connection.disconnect();
		response = new StringBuffer(
				// "<?xml version=\"1.0\" encoding=\"UTF-8\"
				// standalone=\"yes\"?>"+
				"<RetourWS><idCompteDebite>3</idCompteDebite><idCompteCredite>1</idCompteCredite><typeOperation>transfert</typeOperation><montant>2</montant></RetourWS>");
		System.out.println("response :" + response.toString());

		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("eclipselink.media - type", MediaType.APPLICATION_XML_VALUE);
		properties.put(MarshallerProperties.JSON_INCLUDE_ROOT, false);

		JAXBContext ctx = JAXBContextFactory.createContext(new Class[] { RetourWS.class }, properties);
		Unmarshaller jsonUnmarshaller = ctx.createUnmarshaller();
		// StreamSource jsonStream2 = new
		// StreamSource(connection.getInputStream());
		// List<HistoriqueOperations> lstHisto = (List<HistoriqueOperations>)
		// jsonUnmarshaller
		// .unmarshal(jsonStream2, HistoriqueOperations.class).getValue();
		@SuppressWarnings("unchecked")
		RetourWS retourWS = (RetourWS) jsonUnmarshaller
				.unmarshal(new StreamSource(new StringReader(response.toString())));

		// connection.disconnect();

		System.out.println(retourWS);

	}

}