package br.com.project.daoimpl;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.project.dao.UsuarioDAO;
import br.com.project.modelo.Empresa;
import br.com.project.modelo.Usuario;

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
	
	public Collection<Object> lista(){
		
		StringBuilder jpql = new StringBuilder();
		
		jpql.append("select a from Usuario a");
				
		Query query = entityManager.createQuery(jpql.toString());
		
		System.out.println((Collection<Object>) query.getResultList());
		return (Collection<Object>) query.getResultList();
	}
	
	@Override
	public Long idtUsuario() {
		
		StringBuilder jpql = new StringBuilder();
    	jpql.append("SELECT COUNT(e.idtUsuario) + 1 FROM Usuario AS e ");
		
    	Query query = entityManager.createQuery(jpql.toString());
		
		Long idtUsuario = (Long) query.getSingleResult();
		
		return idtUsuario;	
	}
	
	@Override
	public Usuario buscaUsuario(Usuario usuario) {

		String jpql = "FROM Usuario u WHERE u.emailUsuario = ?1 ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter(1, usuario.getEmailUsuario());
		
		return (Usuario) query.getSingleResult();
		
		/*usuario = (Usuario) entityManager.createQuery("SELECT u FROM Usuario u WHERE u.emailUsuario = ?1")
				 .setParameter("?1", usuario.getEmailUsuario())
				 .getSingleResult();
		
		return usuario;*/	
	}
	
}	