package br.com.project.boimpl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.project.bo.UsuarioBO;
import br.com.project.dao.UsuarioDAO;
import br.com.project.modelo.Usuario;
import br.com.project.util.RetornoGenericoVO;

@Service("UsuarioBOImpl")
public class UsuarioBOImpl implements UsuarioBO{

	@Autowired
	private UsuarioDAO usuarioDAO;
		
	@Override
	@Transactional
	public RetornoGenericoVO gravarNovoUsuario(Usuario usuario){
		
		usuarioDAO.salvar(usuario);
		
		return new RetornoGenericoVO(true, new StringBuilder("Usuário inserido com sucesso"), 0);
	}
	
	@Override
	public Collection<Usuario> buscarUsuarios(){
		
		return usuarioDAO.buscarUsuarios();
	}
}

	
