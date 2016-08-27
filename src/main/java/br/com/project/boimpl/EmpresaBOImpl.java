/**
 * 
 */
package br.com.project.boimpl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.project.bo.EmpresaBO;
import br.com.project.modelo.Empresa;

/**
 * @author Maçana
 *
 */
public class EmpresaBOImpl implements EmpresaBO{
	
	@Autowired
	private EmpresaBO empresaBO;
	
	@Autowired
	private EmpresaBO empresaDAO;
	
	public Collection<Empresa> buscaEmpresas(){
		return empresaDAO.buscaEmpresas();		
	}
	
	

	
}
