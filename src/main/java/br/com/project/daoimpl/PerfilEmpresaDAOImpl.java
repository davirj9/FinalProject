package br.com.project.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.jdbc.PreparedStatement;

import br.com.project.dao.PerfilEmpresaDAO;
import br.com.project.dao.UsuarioDAO;
import br.com.project.modelo.PerfilEmpresa;
import br.com.project.modelo.Usuario;
import br.com.project.util.Util;

@Repository
public class PerfilEmpresaDAOImpl implements PerfilEmpresaDAO{
	
	private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PerfilEmpresa> buscarPerfis() {
		
		StringBuilder jpql = new StringBuilder();
		
		jpql.append("select p from PerfilEmpresa p");
				
		Query query = entityManager.createQuery(jpql.toString());
		
		return (List<PerfilEmpresa>) query.getResultList();
	}
}	