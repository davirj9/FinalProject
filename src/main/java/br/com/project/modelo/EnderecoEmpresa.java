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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Maçana
 *
 */

@Entity
@Table(name = "endereco_empresa")
public class EnderecoEmpresa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "idt_endereco")
	private Integer idtEndereco;

	@Column(name = "bairro")
	private String bairro;
	
	@Column(name = "uf")
	private String uf;

	@Column(name = "logradouro")  
    private String descricao_logradouro;
	
	@Column(name = "numero")  
    private String numero;
	
	@Column(name="complemento_endereco")
	private String complemento_endereco;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_inclusao")
	private Date data_inclusao;
	
	@Column(name = "NUM_CEP")  
    private String numCep;
	
	@OneToMany(/*cascade = CascadeType.MERGE,*/ mappedBy = "perfilEmpresa"/*, fetch = FetchType.EAGER*/)
    private Set<Empresa> Empresa;

	public Integer getIdtEndereco() {
		return idtEndereco;
	}

	public void setIdtEndereco(Integer idtEndereco) {
		this.idtEndereco = idtEndereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getDescricao_logradouro() {
		return descricao_logradouro;
	}

	public void setDescricao_logradouro(String descricao_logradouro) {
		this.descricao_logradouro = descricao_logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento_endereco() {
		return complemento_endereco;
	}

	public void setComplemento_endereco(String complemento_endereco) {
		this.complemento_endereco = complemento_endereco;
	}

	public Date getData_inclusao() {
		return data_inclusao;
	}

	public void setData_inclusao(Date data_inclusao) {
		this.data_inclusao = data_inclusao;
	}

	public String getNumCep() {
		return numCep;
	}

	public void setNumCep(String numCep) {
		this.numCep = numCep;
	}

	public Set<Empresa> getEmpresa() {
		return Empresa;
	}

	public void setEmpresa(Set<Empresa> empresa) {
		Empresa = empresa;
	}
	
	
}
