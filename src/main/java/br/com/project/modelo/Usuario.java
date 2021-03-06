package br.com.project.modelo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * @author Maçana
 *
 */
@Entity
@Table(name="usuario")
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="idt_usuario")
	private Integer idtUsuario;
	
	@Column(name="nome_usuario")
	private String nomeUsuario;
	
	@Column(name="senha")
	private String senhaUsuario;
	
	@Column(name="email_usuario")
	private String emailUsuario;

	@OneToMany(/*cascade = CascadeType.MERGE,*/mappedBy = "usuario")
	private Set<Empresa> empresa;

	public Integer getIdtUsuario() {
		return idtUsuario;
	}

	public void setIdtUsuario(Integer idtUsuario) {
		this.idtUsuario = idtUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public Set<Empresa> getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Set<Empresa> empresa) {
		this.empresa = empresa;
	}
}
