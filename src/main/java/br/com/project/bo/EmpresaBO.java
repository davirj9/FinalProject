/**
 * 
 */
package br.com.project.bo;

import java.util.Collection;

import org.json.JSONException;

import br.com.project.modelo.Empresa;

/**
 * @author Maçana
 *
 */
public interface EmpresaBO {

	public abstract Collection<Empresa> buscaEmpresas();
	public abstract String getEstado(String Latitude, String Longitude) throws JSONException, Exception;
	public abstract String readUrl(String urlString) throws Exception;
}
