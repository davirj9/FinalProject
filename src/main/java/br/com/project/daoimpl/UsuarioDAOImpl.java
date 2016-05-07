package br.com.project.daoimpl;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.project.dao.UsuarioDAO;
import br.com.project.modelo.Usuario;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO{
	
	private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
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
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("select a from Usuario a");
				
		Query query = entityManager.createQuery(sql.toString());
		
		return (Collection<Usuario>) query.getResultList();
	}
	
}	