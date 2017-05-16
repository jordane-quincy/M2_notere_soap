package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.bind.JAXBException;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;

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
		System.out.println("response :" + response.toString());
	}

}
