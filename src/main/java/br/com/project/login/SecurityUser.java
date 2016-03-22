package br.com.project.login;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.project.modelo.Usuario;

public class SecurityUser implements UserDetails{
	private static final long serialVersionUID = 1L;
		
	private Usuario usuario;

	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPassword() {
		if(getUsuario() != null)
			return getUsuario().getNomeUsuario();
		else
		return null;
	}

	public String getUsername() {
		if(getUsuario() != null)
			return getUsuario().getNomeUsuario();
		else
			return null;
	}

	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
