/**
 * 
 */
package br.com.project.bo;

import java.util.Collection;
import java.util.List;

import org.json.JSONException;

import br.com.project.modelo.Empresa;
import br.com.project.modelo.Usuario;
import br.com.project.vo.EmpresaVO;
import br.com.project.vo.EmpresaVO2;

/**
 * @author Maçana
 *
 */
public interface EmpresaBO {

	public abstract Collection<Empresa> buscaEmpresas(String estado);
	public abstract String getEstado(String Latitude, String Longitude) throws JSONException, Exception;
	public abstract String readUrl(String urlString) throws Exception;
	public abstract Collection<EmpresaVO2> buscaEmpresasLatLong(String latitude, String longitude, String raio, String perfil);
	public abstract Collection<EmpresaVO2> adicionarDadosEmpresas(List<Object[]> list);
	public abstract EmpresaVO adicionaEditaEmpresa(EmpresaVO empresa) throws Exception;
	public abstract List<Empresa> retornaEmpresasPorUsuario(Usuario usuario);
	public abstract void excluirEmpresa(String idtempresa);
}
