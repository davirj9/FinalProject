/**
 * 
 */
package br.com.project.daoimpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import org.springframework.stereotype.Repository;

import br.com.project.dao.EstadoDAO;
import br.com.project.modelo.Estado;

/**
 * @author Maçana
 *
 */

@Repository
public class EstadoDAOImpl implements EstadoDAO {
	
	private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public Estado buscaEstado(String uf){
		
		try{
		StringBuilder jpql = new StringBuilder();
		
		jpql.append("SELECT e FROM Estado e");
		jpql.append(" WHERE e.uf = ?1");
		
		Query query = entityManager.createQuery(jpql.toString());
		
		query.setParameter(1, uf);
		
		Estado estado = (Estado) query.getSingleResult();
		
		return estado;
		}catch (Exception ex) {
            JOptionPane.showInputDialog(this, ex);
        }
		return null;
	}
	
	

}
