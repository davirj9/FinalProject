/**
 * 
 */
package br.com.project.bo;

import java.util.Collection;

import br.com.project.modelo.Empresa;

/**
 * @author Maçana
 *
 */
public interface EmpresaBO {

	public abstract Collection<Empresa> buscaEmpresas();
}
