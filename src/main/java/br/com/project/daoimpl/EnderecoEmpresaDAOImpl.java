/**
 * 
 */
package br.com.project.daoimpl;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.project.dao.EnderecoEmpresaDAO;
import br.com.project.modelo.EnderecoEmpresa;
import br.com.project.vo.EmpresaVO;

/**
 * @author Maçana
 *
 */

@Repository
public class EnderecoEmpresaDAOImpl implements EnderecoEmpresaDAO {

private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	@Transactional
	public EnderecoEmpresa salvar(EnderecoEmpresa enderecoEmpresa){
		entityManager.merge(enderecoEmpresa);  
		return enderecoEmpresa;
	}
	
	@Override
	@Transactional
	public void inserir(EmpresaVO empresaVO) throws Exception {
		try{
			StringBuilder sql = new StringBuilder();
		
			Date data = new Date(System.currentTimeMillis());  
			SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-MM-dd"); 
			
			sql.append("insert into endereco_empresa (idt_endereco, bairro, complemento_endereco, data_inclusao, logradouro, latitude,"
					+ " longitude, num_cep, numero, uf) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ? )");
					
			entityManager.createNativeQuery(sql.toString()).
				setParameter(1, empresaVO.getIdtEnderecoEmpresa()).
				setParameter(2, empresaVO.getBairro()).
				setParameter(3, empresaVO.getComplemento_endereco()).
				setParameter(4, formatarDate.format(data)).
				setParameter(5, empresaVO.getDescricao_logradouro()).
				setParameter(6, empresaVO.getLatitude()).
				setParameter(7, empresaVO.getLongitude()).
				setParameter(8, empresaVO.getNumCep()).
				setParameter(9, empresaVO.getNumero()).
				setParameter(10, empresaVO.getUf()).
				executeUpdate();
			
		}catch(Exception  e){
			System.out.println(e);
		}
	}
	
	@Override
	public Long idtEndereco(){
		
		StringBuilder jpql = new StringBuilder();
    	jpql.append("SELECT COUNT(e.idtEndereco) + 1 FROM EnderecoEmpresa AS e ");
		
    	Query query = entityManager.createQuery(jpql.toString());
		
		Long idtEndereco = (Long) query.getSingleResult();
		
		return idtEndereco;
	}
}
