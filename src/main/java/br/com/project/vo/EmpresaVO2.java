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
public class EmpresaVO2 {
	
	private Integer idtEmpresa;
	private String nomeEmpresa;
	private String bairro;
	private String complemento_endereco;
	private String descricao_logradouro;
	private String numero;
	private String numCep;
	private String latitude;
	private String longitude;
	private String descricaoPerfil;
	private Double distancia;
	
	public Integer getIdtEmpresa() {
		return idtEmpresa;
	}
	public void setIdtEmpresa(Integer idtEmpresa) {
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
}
