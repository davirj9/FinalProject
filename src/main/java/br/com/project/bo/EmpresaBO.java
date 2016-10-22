/**
 * 
 */
package br.com.project.bo;

import java.util.Collection;
import java.util.List;

import org.json.JSONException;

import br.com.project.modelo.Empresa;
import br.com.project.vo.EmpresaVO;

/**
 * @author Maçana
 *
 */
public interface EmpresaBO {

	public abstract Collection<Empresa> buscaEmpresas(String estado);
	public abstract String getEstado(String Latitude, String Longitude) throws JSONException, Exception;
	public abstract String readUrl(String urlString) throws Exception;
	public abstract Collection<EmpresaVO> buscaEmpresasLatLong(String latitude, String longitude, Integer raio);
	public abstract Collection<EmpresaVO> adicionarDadosEmpresas(List<Object[]> list);
}
