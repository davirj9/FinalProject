package br.com.project.daoimpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	public Usuario salvar(Usuario usuario){
		
		usuario = entityManager.merge(usuario);
		return usuario;
	}
	
	//private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioDAOImpl.class);
	
	
	

}
