/**
 * 
 */
package br.com.project.util;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

import br.com.project.dao.EstadoDAO;
import br.com.project.daoimpl.EstadoDAOImpl;
import br.com.project.modelo.Estado;

/**
 * @author Maçana
 *
 */
public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
		
		System.out.println("Foi !");
		
	}

}
