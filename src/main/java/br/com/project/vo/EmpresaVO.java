/**
 * 
 */
package br.com.project.vo;

import java.util.Date;

import br.com.project.modelo.Usuario;

/**
 * @author Maçana
 *
 */
public class EmpresaVO {
	
	protected Long idtEmpresa;
	protected Long idtEnderecoEmpresa;
	protected String nomeEmpresa;
	protected String bairro;
	protected String complemento_endereco;
	protected String descricao_logradouro;
	protected String numero;
	protected String numCep;
	protected String latitude;
	protected String longitude;
	protected String descricaoPerfil;
	protected String uf;
	protected Double distancia;
	protected Date dataInclusao;
	protected Long idtPerfil;
	protected Usuario usuarioLogado;
	
	public Long getIdtEmpresa() {
		return idtEmpresa;
	}
	public Long getIdtEnderecoEmpresa() {
		return idtEnderecoEmpresa;
	}
	public void setIdtEnderecoEmpresa(Long idtEnderecoEmpresa) {
		this.idtEnderecoEmpresa = idtEnderecoEmpresa;
	}
	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}
	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	public void setIdtEmpresa(Long idtEmpresa) {
		this.idtEmpresa = idtEmpresa;
	}
	public String getNomeEmpresa() {
		return nomeEmpresa;
	}
	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getComplemento_endereco() {
		return complemento_endereco;
	}
	public void setComplemento_endereco(String complemento_endereco) {
		this.complemento_endereco = complemento_endereco;
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
	public String getNumCep() {
		return numCep;
	}
	public void setNumCep(String numCep) {
		this.numCep = numCep;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getDescricaoPerfil() {
		return descricaoPerfil;
	}
	public void setDescricaoPerfil(String descricaoPerfil) {
		this.descricaoPerfil = descricaoPerfil;
	}
	public Double getDistancia() {
		return distancia;
	}
	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public Date getDataInclusao() {
		return dataInclusao;
	}
	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}
	public Long getIdtPerfil() {
		return idtPerfil;
	}
	public void setIdtPerfil(Long idtPerfil) {
		this.idtPerfil = idtPerfil;
	}
}
