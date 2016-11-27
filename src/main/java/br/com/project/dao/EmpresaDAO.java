/**
 * 
 */
package br.com.project.dao;

import java.util.Collection;
import java.util.List;

import br.com.project.modelo.Empresa;
import br.com.project.vo.EmpresaVO;


/**
 * @author Maçana
 *
 */
public interface EmpresaDAO {
	
	public abstract List<Empresa> buscarEmpresasPorFiltro(String estado);
	public abstract Empresa consultaPorIdt(Integer idtEmpresa);
	public abstract List<Object[]> buscarEmpresasPorLatLong(String latitude, String longitude, String raio, String perfil);
	public abstract List<Empresa> consultaPorIdts(String idtEmpresa);
	public abstract void inserir(EmpresaVO empresaVO);
	public abstract Long idtEmpresa();

}
