/**
 * 
 */
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
@Table(name="perfilEmpresa")
public class PerfilEmpresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "idt_perfil")
	private Integer idtPerfil;
	
	@Column(name="descricao_perfil")
	private String descricaoPerfil;

	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "perfilEmpresa")
    private Set<Empresa> Empresa;
	
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
