/**
 * 
 */
package br.com.project.daoimpl;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.project.dao.EmpresaDAO;
import br.com.project.modelo.Empresa;
import br.com.project.modelo.Usuario;
import br.com.project.modelo.Usuario;

/**
 * @author Maçana
 *
 */

@Repository
public class EmpresaDAOImpl implements EmpresaDAO{

private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Empresa> buscarEmpresasPorFiltro(String estado) {
	
		StringBuilder jpql = new StringBuilder();
		
		jpql.append("FROM Empresa e");
		
		if(estado != null)
			jpql.append(" WHERE e.enderecoEmpresa.uf = ?1");
		
		Query query = entityManager.createQuery(jpql.toString());
		
		if(estado != null)
			query.setParameter(1, estado);
		
		return (List<Empresa>) query.getResultList();
	}
	
	@Override
	public Empresa consultaPorIdt(Integer idtEmpresa){
		try{
			return entityManager.find(Empresa.class, idtEmpresa);
		}catch(NoResultException nre){
			return null;
		}catch(Exception e){
			System.out.println(e);
		}
		return null;
	}

}
