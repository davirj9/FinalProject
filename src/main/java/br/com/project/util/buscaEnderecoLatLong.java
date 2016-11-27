/**
 * 
 */
package br.com.project.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.util.StringUtils;

import br.com.project.vo.EmpresaVO;

/**
 * @author Maçana
 *
 */
public class buscaEnderecoLatLong {
	
	public EmpresaVO getDados(EmpresaVO empresaVO) throws JSONException, Exception{
		
		String end = "https://maps.google.com/maps/api/geocode/json?address="+empresaVO.getLatitude()+","+empresaVO.getLongitude();
		
		JSONObject jsonObject = new JSONObject(
				readUrl(end));

		if ("OK".equalsIgnoreCase(jsonObject.getString("status"))) {
			for (int i = 0; i < ((JSONArray) jsonObject.get("results")).length(); i++) {

				JSONArray addrComp = ((JSONArray) jsonObject.get("results")).getJSONObject(i)
						.getJSONArray("address_components");
				for (int j = 0; j < addrComp.length(); j++) {
					String adminArea = ((JSONArray) ((JSONObject) addrComp.get(j)).get("types")).getString(0);
					
					if (adminArea.compareTo("administrative_area_level_1") == 0 && StringUtils.isEmpty(empresaVO.getUf())) {
						empresaVO.setUf(((JSONObject) addrComp.get(j)).getString("short_name"));
					}
					if(adminArea.compareTo("political") == 0 && StringUtils.isEmpty(empresaVO.getBairro())){
						empresaVO.setBairro(((JSONObject) addrComp.get(j)).getString("short_name"));
					}
					if(adminArea.compareTo("route") == 0 && StringUtils.isEmpty(empresaVO.getDescricao_logradouro())){
						empresaVO.setDescricao_logradouro(((JSONObject) addrComp.get(j)).getString("long_name"));
					}
					if(adminArea.compareTo("street_number") == 0 && StringUtils.isEmpty(empresaVO.getNumero())){
						empresaVO.setNumero(((JSONObject) addrComp.get(j)).getString("long_name"));
					}
					if(adminArea.compareTo("postal_code") == 0 && StringUtils.isEmpty(empresaVO.getNumCep())){
						empresaVO.setNumCep(((JSONObject) addrComp.get(j)).getString("long_name"));
					}
					
				}
			}
		}
		return empresaVO;
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
