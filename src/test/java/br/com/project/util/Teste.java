/**
 * 
 */
package br.com.project.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.util.StringUtils;

import com.sun.jndi.cosnaming.IiopUrl.Address;
import br.com.project.modelo.Usuario;

/**
 * @author Maçana
 *
 */
public class Teste {

	public static void main(String[] args) throws JSONException, Exception {

		String estado = null;
		String bairro = null;
		String rua = null;
		String numero = null;
		String cep = null;
		
		JSONObject jsonObject = new JSONObject(
				readUrl("https://maps.google.com/maps/api/geocode/json?address=-22.8688003,-43.3640886"));

		if ("OK".equalsIgnoreCase(jsonObject.getString("status"))) {
			for (int i = 0; i < ((JSONArray) jsonObject.get("results")).length(); i++) {

				JSONArray addrComp = ((JSONArray) jsonObject.get("results")).getJSONObject(i)
						.getJSONArray("address_components");
				for (int j = 0; j < addrComp.length(); j++) {
					String adminArea = ((JSONArray) ((JSONObject) addrComp.get(j)).get("types")).getString(0);
					
					if (adminArea.compareTo("administrative_area_level_1") == 0 && StringUtils.isEmpty(estado)) {
						estado = ((JSONObject) addrComp.get(j)).getString("short_name");
					}
					if(adminArea.compareTo("political") == 0 && StringUtils.isEmpty(bairro)){
						bairro = ((JSONObject) addrComp.get(j)).getString("short_name");
					}
					if(adminArea.compareTo("route") == 0 && StringUtils.isEmpty(rua)){
						rua = ((JSONObject) addrComp.get(j)).getString("long_name");
					}
					if(adminArea.compareTo("street_number") == 0 && StringUtils.isEmpty(numero)){
						numero = ((JSONObject) addrComp.get(j)).getString("long_name");
					}
					if(adminArea.compareTo("postal_code") == 0 && StringUtils.isEmpty(cep)){
						cep = ((JSONObject) addrComp.get(j)).getString("long_name");
					}
					
				}
			}
		}
		System.out.println("Estado:" + estado); 
		System.out.println("Bairro:" + bairro);
		System.out.println("Rua:" + rua );
		System.out.println("Número:" + numero);
		System.out.println("Cep:" + cep);
	}

	private static String readUrl(String urlString) throws Exception {
		BufferedReader reader = null;
		try {
			URL url = new URL(urlString);
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			StringBuffer buffer = new StringBuffer();
			int read;
			char[] chars = new char[1024];
			while ((read = reader.read(chars)) != -1)
				buffer.append(chars, 0, read);

			return buffer.toString();
		} finally {
			if (reader != null)
				reader.close();
		}
	}

}
