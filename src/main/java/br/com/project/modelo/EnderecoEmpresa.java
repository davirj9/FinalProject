/**
 * 
 */
package br.com.project.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class EnderecoEmpresa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "idt_endereco")
	private Integer idtEndereco;

	@JoinColumn(name = "idt_empresa", referencedColumnName = "idt_empresa")
	@OneToOne
	private Empresa idtEmpresa;
	
	@JoinColumn(name = "idt_cidade", referencedColumnName = "idt_cidade")
	@ManyToOne
	private Cidade cidade;

	@Column(name = "descricao_endereco")  
    private String dscEndereco;
	
	@Column(name = "bairro")
	private String bairro;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_inclusao")
	private Date data_inclusao;
	
	@Column(name = "NUM_CEP")  
    private String numCep;

	public Integer getIdtEndereco() {
		return idtEndereco;
	}

	public void setIdtEndereco(Integer idtEndereco) {
		this.idtEndereco = idtEndereco;
	}

	public Empresa getIdtEmpresa() {
		return idtEmpresa;
	}

	public void setIdtEmpresa(Empresa idtEmpresa) {
		this.idtEmpresa = idtEmpresa;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String getDscEndereco() {
		return dscEndereco;
	}

	public void setDscEndereco(String dscEndereco) {
		this.dscEndereco = dscEndereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
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

	

}
