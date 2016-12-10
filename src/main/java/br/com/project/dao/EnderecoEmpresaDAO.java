/**
 * 
 */
package br.com.project.dao;

import br.com.project.modelo.EnderecoEmpresa;
import br.com.project.vo.EmpresaVO;

/**
 * @author Maçana
 *
 */
public interface EnderecoEmpresaDAO {

	public abstract EnderecoEmpresa salvar(EnderecoEmpresa enderecoEmpresa);
	public abstract void inserir(EmpresaVO empresaVO) throws Exception;
	public abstract Long idtEndereco();
	public abstract	EnderecoEmpresa consultaPorIdt(Integer idtEmpresa);

}
