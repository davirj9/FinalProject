/**
 * 
 */
package br.com.project.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.core.json.ReaderBasedJsonParser;

/**
 * @author Maçana
 *
 */
public class buscaEnderecoLatLong {
	
	public String getEstado(String Latitude, String Longitude) throws JSONException, Exception{
		
		String estado = null;
		JSONObject jsonObject = new JSONObject(
				readUrl("https://maps.google.com/maps/api/geocode/json?address=-22.8688003,-43.3640886"));

		if ("OK".equalsIgnoreCase(jsonObject.getString("status"))) {
			for (int i = 1; i < ((JSONArray) jsonObject.get("results")).length() - 2; i++) {

				JSONArray addrComp = ((JSONArray) jsonObject.get("results")).getJSONObject(i)
						.getJSONArray("address_components");
				for (int j = 0; j < addrComp.length(); j++) {
					String adminArea = ((JSONArray) ((JSONObject) addrComp.get(j)).get("types")).getString(0);
					if (adminArea.compareTo("administrative_area_level_1") == 0) {
						estado = ((JSONObject) addrComp.get(j)).getString("short_name");
						break;
					}
				}
			}
		}
		return estado;
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
