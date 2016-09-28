/**
 * 
 */
package br.com.project.dao;

import java.util.Collection;

import br.com.project.modelo.Empresa;


/**
 * @author Maçana
 *
 */
public interface EmpresaDAO {
	
	public abstract Collection<Empresa> buscarEmpresasPorFiltro(String estado);
	public abstract Empresa consultaPorIdt(Integer idtEmpresa);

}
