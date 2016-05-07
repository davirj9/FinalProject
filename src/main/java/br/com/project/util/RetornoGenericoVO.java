package br.com.project.util;

import java.util.HashMap;

public class RetornoGenericoVO {

	private boolean isSucesso;
	private StringBuilder mensagem;
	private Integer codigoGenerico;

	public RetornoGenericoVO(){

	}
	
	public RetornoGenericoVO(boolean isSucesso, StringBuilder mensagem){
		this.isSucesso = isSucesso;
		this.mensagem = mensagem;
	}
	
	public RetornoGenericoVO(boolean isSucesso, StringBuilder mensagem, Integer codigoGenerico){
		this.isSucesso = isSucesso;
		this.mensagem = mensagem;
		this.codigoGenerico = codigoGenerico;
	}
	
	public boolean getIsSucesso() {
		return isSucesso;
	}

	public void setIsSucesso(boolean isSucesso) {
		this.isSucesso = isSucesso;
	}

	public StringBuilder getMensagem() {
		return mensagem;
	}

	public void setMensagem(StringBuilder mensagem) {
		this.mensagem = mensagem;
	}

	public Integer getCodigoGenerico() {
		return codigoGenerico;
	}

	public void setCodigoGenerico(Integer codigoGenerico) {
		this.codigoGenerico = codigoGenerico;
	}
	
}
