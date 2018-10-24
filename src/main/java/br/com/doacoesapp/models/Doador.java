package br.com.doacoesapp.models;

import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Doador {
	
	@Id
	private String rg;
	private String NomeDoador;
	
	@ManyToOne
	private Doacao doacao;
	
	
	
	
	public Doacao getDoacao() {
		return doacao;
	}
	public void setDoacao(Doacao doacao) {
		this.doacao = doacao;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getNomeDoador() {
		return NomeDoador;
	}
	public void setNome_doador(String NomeDoador) {
		this.NomeDoador = NomeDoador;
	}
	
	
	
}
