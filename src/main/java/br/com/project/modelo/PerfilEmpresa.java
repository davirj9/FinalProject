/**
 * 
 */
package br.com.project.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Maçana
 *
 */

@Entity
@Table(name="perfilEmpresa")
public class PerfilEmpresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "idt_perfil")
	private Integer idtPerfil;
	
	@Column(name="descricao_perfil")
	private String descricaoPerfil;

	public Integer getIdtPerfil() {
		return idtPerfil;
	}

	public void setIdtPerfil(Integer idtPerfil) {
		this.idtPerfil = idtPerfil;
	}

	public String getDescricaoPerfil() {
		return descricaoPerfil;
	}

	public void setDescricaoPerfil(String descricaoPerfil) {
		this.descricaoPerfil = descricaoPerfil;
	}
	
	
}
