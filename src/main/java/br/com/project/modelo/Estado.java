/**
 * 
 */
package br.com.project.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Maçana
 *
 */

@Entity
@Table(name="estado")
public class Estado implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "idt_estado")
	private Integer idtEstado;
	
	@Column(name = "UF")
	private String uf;
	
	@Column(name = "nome_estado")
	private String nomeEstado;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_inclusao", nullable = false)
	private Date dataInlcusao;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "estado")
	private Set<Cidade> cidades;

	public Integer getIdtEstado() {
		return idtEstado;
	}

	public void setIdtEstado(Integer idtEstado) {
		this.idtEstado = idtEstado;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getNomeEstado() {
		return nomeEstado;
	}

	public void setNomeEstado(String nomeEstado) {
		this.nomeEstado = nomeEstado;
	}

	public Date getDataInlcusao() {
		return dataInlcusao;
	}

	public void setDataInlcusao(Date dataInlcusao) {
		this.dataInlcusao = dataInlcusao;
	}

	public Set<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(Set<Cidade> cidades) {
		this.cidades = cidades;
	}
	
	

}
