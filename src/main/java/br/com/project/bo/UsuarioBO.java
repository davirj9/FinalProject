package br.com.project.bo;

import br.com.project.modelo.Usuario;
import br.com.project.util.RetornoGenericoVO;

public interface UsuarioBO {

	public abstract RetornoGenericoVO gravarNovoUsuario(Usuario usuario);

}
