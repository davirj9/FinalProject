package br.com.project.daoimpl;

import javax.persistence.EntityManager;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sun.istack.internal.logging.Logger;

import br.com.project.dao.UsuarioDAO;
import br.com.project.login.AutenticaLogin;

public class UsuarioDAOImpl implements UsuarioDAO{
	
	private EntityManager entityManager;
	
	@Autowired
	private AutenticaLogin autenticaLogin;
	
	//private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioDAOImpl.class);
	
	
	

}
