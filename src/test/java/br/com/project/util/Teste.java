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

import com.sun.jndi.cosnaming.IiopUrl.Address;
import br.com.project.modelo.Usuario;

/**
 * @author Maçana
 *
 */
public class Teste {

	private static Testando testando;

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		Collection<Object[]> lista = new ArrayList<>();;
		lista.add(new String[] {"Davi Maçana"});
		lista.add(new Integer[] {25});
		lista.add(new String[] {"Masculino"});
		
		Collection<Testando> teste = new ArrayList<>();
		
		testando = null;
		
		for(Object obj : lista){
			Object[] obUnit = (Object[]) obj;
			testando.setNome(String.valueOf(obUnit[0]));
			testando.setIdade((Integer) obUnit[1]);
			testando.setSexo(String.valueOf(obUnit[0]));
			teste.add(testando);
		}	
	}
	
	class Testando{
		
		String nome;
		Integer idade;
		String sexo;
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public Integer getIdade() {
			return idade;
		}
		public void setIdade(Integer idade) {
			this.idade = idade;
		}
		public String getSexo() {
			return sexo;
		}
		public void setSexo(String sexo) {
			this.sexo = sexo;
		}
	}
}
