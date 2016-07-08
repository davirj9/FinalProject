package br.com.project.dao;

import java.util.Collection;

import br.com.project.modelo.Usuario;

public interface UsuarioDAO {

	public abstract Usuario salvar(Usuario usuario);
	public abstract Usuario buscaIdtUsuario(Long idUsuario);
	public abstract Collection<Usuario> buscarUsuarios();
	public abstract boolean autenticaUsuario(Usuario usuario);
}
