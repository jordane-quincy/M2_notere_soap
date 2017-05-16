package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.eclipse.persistence.jaxb.JAXBContextFactory;
import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;

import entity.HistoriqueOperations;

public class MainJson {

	public static void main(String[] args) throws JAXBException, IOException {
		// ou "http://localhost:8080/infos?username=oR"
		String uri = "http://localhost:8080/infos?username=JQuincy";
		URL url = new URL(uri);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod(RequestMethod.GET.name());
		connection.setRequestProperty("Accept", MediaType.APPLICATION_JSON_VALUE);

		InputStream is = connection.getInputStream();
		BufferedReader rd = new BufferedReader(new InputStreamReader(is));
		StringBuffer response = new StringBuffer();
		String line;
		while ((line = rd.readLine()) != null) {
			response.append(line).append('\r');
		}
		connection.disconnect();
		// response = new StringBuffer(
		// "{\"id\":1,\"compte\":{\"id\":3},\"dateOperation\":\"2017-04-27\",\"operation\":\"DEBIT\",\"montant\":2.00}");
		System.out.println("response :" + response.toString());

		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("eclipselink.media-type", MediaType.APPLICATION_JSON_VALUE);
		properties.put(MarshallerProperties.JSON_INCLUDE_ROOT, false);

		JAXBContext ctx = JAXBContextFactory.createContext(new Class[] { HistoriqueOperations.class }, properties);
		Unmarshaller jsonUnmarshaller = ctx.createUnmarshaller();
		// StreamSource jsonStream2 = new
		// StreamSource(connection.getInputStream());
		// List<HistoriqueOperations> lstHisto = (List<HistoriqueOperations>)
		// jsonUnmarshaller
		// .unmarshal(jsonStream2, HistoriqueOperations.class).getValue();

		// @SuppressWarnings("unchecked")
		// List<HistoriqueOperations> lstHisto = (List<HistoriqueOperations>)
		// jsonUnmarshaller
		// .unmarshal(new StreamSource(new StringReader(response.toString())));

		// try {
		// XMLInputFactory xmlif = XMLInputFactory.newInstance();
		//
		// XMLEventReader xmlEventReader = xmlif.createXMLEventReader(new
		// StringReader(response.toString()));
		// List<HistoriqueOperations> lstHisto = (List<HistoriqueOperations>)
		// jsonUnmarshaller
		// .unmarshal(xmlEventReader);
		// for (HistoriqueOperations historique : lstHisto) {
		// System.out.println(historique);
		// }
		// } catch (XMLStreamException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// connection.disconnect();

	}

}
