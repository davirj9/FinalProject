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

import br.com.project.dao.UsuarioDAO;
import br.com.project.modelo.Usuario;
import br.com.project.util.Util;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO{
	
	private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override	
	public Boolean autenticaUsuario(Usuario usuario) {
		boolean autenticado = false;
		
        try {
        	StringBuilder jpql = new StringBuilder();
        	jpql.append("SELECT COUNT(u.idtUsuario) FROM Usuario AS u ");
        	jpql.append("WHERE u.emailUsuario = ?1 AND u.senhaUsuario = ?2");
			
        	Query query = entityManager.createQuery(jpql.toString());
			
			query.setParameter(1, usuario.getEmailUsuario());
			query.setParameter(2, usuario.getSenhaUsuario());
			
			Long total = (Long) query.getSingleResult();
            
			if(total > 0)
				return true;
			else
				return false;
			
        } catch (Exception ex) {
            JOptionPane.showInputDialog(this, ex);
        }
        return autenticado;
    }
	
	@Override
	@Transactional
	public Usuario salvar(Usuario usuario){
		/*EntityManagerFactory factory = Persistence.
		        createEntityManagerFactory("System");
		    EntityManager manager = factory.createEntityManager();
		    
		manager.getTransaction().begin();   */
		entityManager.merge(usuario);
		/*manager.merge(usuario);
	    manager.getTransaction().commit();*/  
		return usuario;
	}
	//private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioDAOImpl.class);
	
	@Override
	public Usuario buscaIdtUsuario(Long idUsuario){
		
		return entityManager.find(Usuario.class, idUsuario);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Usuario> buscarUsuarios() {
		
		StringBuilder jpql = new StringBuilder();
		
		jpql.append("select a from Usuario a");
				
		Query query = entityManager.createQuery(jpql.toString());
		
		return (Collection<Usuario>) query.getResultList();
	}
	
	
	
}	