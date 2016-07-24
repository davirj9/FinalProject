/**
 * 
 */
package br.com.project.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * @author Maçana
 *
 */
@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "idt_empresa")
	private Integer idtEmpresa;
	
	@Column(name = "nome_empresa")
	private String nomeEmpresa;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_inclusao")
	private Date data_inclusao;
	
	@JoinColumn(name = "idt_perfil", referencedColumnName = "idt_perfil")
	@ManyToOne(fetch = FetchType.LAZY)
	private PerfilEmpresa perfilEmpresa;

	@JoinColumn(name = "idt_usuario", referencedColumnName = "idt_usuario")
	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario usuario;
	
	@Transient
	private PerfilEmpresa descricaoPerfil;
	
	@JoinColumn(name = "idt_empresa", referencedColumnName = "idt_empresa")
	@OneToOne
	private EnderecoEmpresa enderecoEmpresa;

	public PerfilEmpresa getDescricaoPerfil() {
		return descricaoPerfil;
	}

	public void setDescricaoPerfil(PerfilEmpresa descricaoPerfil) {
		this.descricaoPerfil = descricaoPerfil;
	}
	
	public Integer getIdtEmpresa() {
		return idtEmpresa;
	}
	
	public void setIdtEmpresa(Integer idtEmpresa) {
		this.idtEmpresa = idtEmpresa;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public Date getData_inclusao() {
		return data_inclusao;
	}

	public void setData_inclusao(Date data_inclusao) {
		this.data_inclusao = data_inclusao;
	}

	public Usuario getIdtUsuario() {
		return usuario;
	}

	public void setIdtUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public PerfilEmpresa getPerfilEmpresa() {
		return perfilEmpresa;
	}

	public void setPerfilEmpresa(PerfilEmpresa perfilEmpresa) {
		this.perfilEmpresa = perfilEmpresa;
	}

	public EnderecoEmpresa getEnderecoEmpresa() {
		return enderecoEmpresa;
	}

	public void setEnderecoEmpresa(EnderecoEmpresa enderecoEmpresa) {
		this.enderecoEmpresa = enderecoEmpresa;
	}

}
