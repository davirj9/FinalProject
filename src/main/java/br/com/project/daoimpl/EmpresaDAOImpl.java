/**
 * 
 */
package br.com.project.daoimpl;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.project.dao.EmpresaDAO;
import br.com.project.modelo.Empresa;
import br.com.project.modelo.Estado;
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
	public Collection<Empresa> buscarEmpresasPorFiltro(Estado estado) {
	
		StringBuilder jpql = new StringBuilder();
		
		//jpql.append("SELECT e FROM Empresa e");
		//jpql.append(" LEFT JOIN e.EnderecoEmpresa AS ee");
		//jpql.append(" WHERE ee.idt_estado = ?1");
		
		jpql.append("SELECT e FROM Empresa e");
		
		Query query = entityManager.createQuery(jpql.toString());
		
		//query.setParameter(1, estado.getIdtEstado());
		
		return (Collection<Empresa>) query.getResultList();
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
