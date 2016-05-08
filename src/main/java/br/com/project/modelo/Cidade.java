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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Maçana
 *
 */
@Entity
@Table(name="cidade")
public class Cidade implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "idt_cidade")
	private Integer idtCidade;
	
	@JoinColumn(name = "idt_estado", referencedColumnName = "idt_estado")
	@ManyToOne(fetch = FetchType.LAZY)
	private Estado estado;
	
	@Column(name = "sigla_cidade")
	private String siglaCidade;
	
	@Column(name = "nome_cidade")
	private String nomeCidade;
	
	@Column(name = "numero_ddd")
	private String numeroDdd;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATA_INCLUSAO", nullable = false)
	private Date dataInlcusao;

	public Integer getIdtCidade() {
		return idtCidade;
	}

	public void setIdtCidade(Integer idtCidade) {
		this.idtCidade = idtCidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getSiglaCidade() {
		return siglaCidade;
	}

	public void setSiglaCidade(String siglaCidade) {
		this.siglaCidade = siglaCidade;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	public String getNumeroDdd() {
		return numeroDdd;
	}

	public void setNumeroDdd(String numeroDdd) {
		this.numeroDdd = numeroDdd;
	}

	public Date getDataInlcusao() {
		return dataInlcusao;
	}

	public void setDataInlcusao(Date dataInlcusao) {
		this.dataInlcusao = dataInlcusao;
	}

	
}
