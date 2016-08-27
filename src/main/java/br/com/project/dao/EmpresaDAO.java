/**
 * 
 */
package br.com.project.dao;

import java.util.Collection;

import br.com.project.modelo.Empresa;
import br.com.project.modelo.Estado;


/**
 * @author Maçana
 *
 */
public interface EmpresaDAO {
	
	public abstract Collection<Empresa> buscarEmpresasPorFiltro(Estado estado);
	public abstract Empresa consultaPorIdt(Integer idtEmpresa);

}
