package br.com.project.bo;

import java.util.Collection;

import br.com.project.modelo.Usuario;
import br.com.project.util.RetornoGenericoVO;

public interface UsuarioBO {

	public abstract RetornoGenericoVO gravarNovoUsuario(Usuario usuario);
	public abstract Collection<Usuario> buscarUsuarios();
}
